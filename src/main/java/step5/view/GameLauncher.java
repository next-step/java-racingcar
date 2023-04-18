package step5.view;

import step5.domain.RacingGame;
import step5.domain.stretagy.SimpleRandomMovingStrategy;

public class GameLauncher {

    public static void main(String[] args) {
        String names = View.getNameOfCars();
        int tryCount = View.getTryCount();
        View.printStart();

        RacingGame.setUp(names, new SimpleRandomMovingStrategy());
        for (int i = 0; i < tryCount; i++) {
            View.printEachResult(RacingGame.race());
        }
        View.printWinner(RacingGame.getWinners());
    }

}
