package racing;

import racing.component.RacingGame;
import racing.dto.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultMain {


    public static void main(String[] args) {

        //RacingGame rg = new RacingGame(InputView.numOfCars(), InputView.times());

        RacingGame rg = new RacingGame(InputView.numOfCarsByNames(), InputView.times());

        for (int i = 0; i < rg.getTimes(); i++) {
            rg.startGame();
            ResultView.gameResult(rg.getCars());
        }

        ResultView.getWinnersList(rg.racingWinners(rg.getCars()));
    }

}
