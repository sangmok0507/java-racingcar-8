package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class GameModel {
    private final String[] cars;
    private final List<List<Character>> resultOfMovement;
    private final List<String> winner;

    public GameModel(String carName) {
        String[] cars = carName.split(",");
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
}
