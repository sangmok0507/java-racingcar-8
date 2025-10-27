package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        final String delimiter = ",";
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine();
        if (!carName.contains(delimiter)) {
            throw new IllegalArgumentException("올바른 구분자를 입력하세요.");
        }
        String[] cars = carName.split(delimiter);
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        List<List<Character>> resultOfMovement = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = new ArrayList<>();
            resultOfMovement.add(list);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < cars.length; j++) {
                int number = Randoms.pickNumberInRange(0, 9);
                if (number >= 4) {
                    resultOfMovement.get(j).add('-');
                }
            }
            for (int j = 0; j < cars.length; j++) {
                System.out.print(cars[j] + " : ");
                List<Character> list = resultOfMovement.get(j);
                for (Character c : list) {
                    System.out.print(c);
                }
                System.out.println();
            }
            System.out.println();
        }

        List<String> winner = new ArrayList<>();
        int max = resultOfMovement.getFirst().size();
        for (List<Character> r : resultOfMovement) {
            if (max < r.size()) {
                max = r.size();
            }
        }
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = resultOfMovement.get(i);
            if (max == list.size()) {
                winner.add(cars[i]);
            }
        }
        System.out.print("최종 우승자 : ");
        if (winner.size() == 1) {
            System.out.println(winner.getFirst());
        } else {
            for (int i = 0; i < winner.size() - 1; i++) {
                System.out.print(winner.get(i) + ", ");
            }
            System.out.println(winner.getLast());
        }
    }
}
