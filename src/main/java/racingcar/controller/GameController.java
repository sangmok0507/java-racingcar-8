package racingcar.controller;

import racingcar.model.GameModel;
import racingcar.view.GameView;

public class GameController {
    private final GameModel model;
    private final GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void playGame() {
        int count = view.getCount();
        System.out.println("\n실행 결과");
        for (int i = 0; i < count; i++) {
            model.movementOfCar();
            view.printResultOfRace(model.getCars(), model.getResultOfMovement());
        }
        model.findWinner(model.getMax());
        view.printWinner(model.getWinner());
    }
}
