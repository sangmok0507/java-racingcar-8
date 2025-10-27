package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class GameModel {
    private final String[] cars;
    private final List<List<Character>> resultOfMovement;
    private final List<String> winner;

    public GameModel(String carName) {
        isDelimiter(carName);
        String[] cars = carName.split(",");
        isRightCarName(cars);

        this.cars = cars;
        this.resultOfMovement = getResultOfMovement(cars);
        this.winner = new ArrayList<>();
    }

    public String[] getCars() {
        return cars;
    }

    public List<List<Character>> getResultOfMovement() {
        return resultOfMovement;
    }

    public int getMax() {
        int max = resultOfMovement.getFirst().size();
        for (List<Character> r : resultOfMovement) {
            if (max < r.size()) {
                max = r.size();
            }
        }
        return max;
    }

    public List<String> getWinner() {
        return winner;
    }

    public void movementOfCar() {
        for (int j = 0; j < cars.length; j++) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (number >= 4) {
                resultOfMovement.get(j).add('-');
            }
        }
    }

    private List<List<Character>> getResultOfMovement(String[] cars) {
        List<List<Character>> resultOfMovement = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = new ArrayList<>();
            resultOfMovement.add(list);
        }
        return resultOfMovement;
    }

    public void findWinner(int max) {
        for (int i = 0; i < cars.length; i++) {
            List<Character> list = resultOfMovement.get(i);
            if (max == list.size()) {
                winner.add(cars[i]);
            }
        }
    }

    public void isRightCarName(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (car.isEmpty()) {
                throw new IllegalArgumentException("올바른 자동차 이름을 입력하세요.");
            }
        }
    }

    public void isDelimiter(String carName) {
        if (!carName.contains(",")) {
            throw new IllegalArgumentException("올바른 구분자를 입력하세요.");
        }
    }

}
