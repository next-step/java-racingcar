package racingcar;

import racingcar.model.RaceGame;
import racingcar.model.RandomCommander;
import racingcar.view.ClientView;
import racingcar.view.RenderingView;

public class RaceGameStarter {

    public static void main(String[] args) {
        String[] carNames = ClientView.inputCarName();
        int totalRound = ClientView.inputTotalRound();

        RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());
        RenderingView renderingView = new RenderingView(carNames.length, carNames);

        for (int i = 0; i < totalRound; i++) {
            raceGame = raceGame.start();
            renderingView.renderView(raceGame);
        }
        renderingView.outPutWinner(raceGame);

    }



}
