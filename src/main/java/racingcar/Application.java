package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        String carName = getCarName();
        isDelimiter(carName);

        String[] cars = carName.split(",");
        isRightCarName(cars);

        List<List<Character>> resultOfMovement = getResultOfMovement(cars);
        int count = getCount();

        playGame(count, cars, resultOfMovement);

        List<String> winner = new ArrayList<>();
        int max = getMax(resultOfMovement);
        
        findWinner(cars, resultOfMovement, max, winner);
        printWinner(winner);
    }

    private static void playGame(int count, String[] cars, List<List<Character>> resultOfMovement) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            movementOfCar(cars, resultOfMovement);
            printResultOfRace(cars, resultOfMovement);
        }
    }

    private static void isRightCarName(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (car.isEmpty()) {
                throw new IllegalArgumentException("올바른 자동차 이름을 입력하세요.");
            }
        }
    }

    private static void isDelimiter(String carName) {
        if (!carName.contains(",")) {
            throw new IllegalArgumentException("올바른 구분자를 입력하세요.");
        }
    }

    private static String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private static int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static List<List<Character>> getResultOfMovement(String[] cars) {
        List<List<Character>> resultOfMovement = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = new ArrayList<>();
            resultOfMovement.add(list);
        }
        return resultOfMovement;
    }

    private static void movementOfCar(String[] cars, List<List<Character>> resultOfMovement) {
        for (int j = 0; j < cars.length; j++) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                resultOfMovement.get(j).add('-');
            }
        }
    }

    private static void printResultOfRace(String[] cars, List<List<Character>> resultOfMovement) {
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

    private static void findWinner(String[] cars, List<List<Character>> resultOfMovement, int max, List<String> winner) {
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = resultOfMovement.get(i);
            if (max == list.size()) {
                winner.add(cars[i]);
            }
        }
    }

    private static int getMax(List<List<Character>> resultOfMovement) {
        int max = resultOfMovement.getFirst().size();
        for (List<Character> r : resultOfMovement) {
            if (max < r.size()) {
                max = r.size();
            }
        }
        return max;
    }

    private static void printWinner(List<String> winner) {
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

