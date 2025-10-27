package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class GameView {
    public String getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printResultOfRace(String[] cars, List<List<Character>> resultOfMovement) {
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

    public void printWinner(List<String> winner) {
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
