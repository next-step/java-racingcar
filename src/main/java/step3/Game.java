package step3;

import step3.model.CarGroup;
import step3.view.ResultView;

import java.util.Random;

public class Game {
    private final int gameCount;

    public Game(int gameCount) {
        this.gameCount = gameCount;
    }

    public void run(CarGroup carGroup) {
        Random random = new Random();
        for (int i = 0; i < gameCount; i++) {
            carGroup.move(random);
            ResultView.showResultOfTurn(carGroup);
        }
    }
}
