package racingcar;

import racingcar.controller.GameController;
import racingcar.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameView view = new GameView();
        GameController controller = new GameController(view);

        controller.playGame();
    }
}

