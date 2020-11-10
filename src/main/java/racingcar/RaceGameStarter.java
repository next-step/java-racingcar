package racingcar;

import racingcar.domain.RaceGame;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomCommander;
import racingcar.view.ClientView;
import racingcar.view.RenderingView;

public class RaceGameStarter {

    public static void main(String[] args) {
        String[] carNames = ClientView.inputCarName();
        int totalRound = ClientView.inputTotalRound();

        RaceGame raceGame = new RaceGame(carNames, totalRound, new RandomCommander());
        RenderingView renderingView = new RenderingView(carNames.length, carNames);

        RacingCars cars = null;
        for (int i = 0; i < totalRound; i++) {
            cars = raceGame.start();
            renderingView.renderResult(cars);
        }
        renderingView.renderWinner(cars);

    }



}
