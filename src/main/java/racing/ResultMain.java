package racing;

import racing.component.RacingGame;
import racing.dto.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultMain {


    public static void main(String[] args) {

        RacingGame rg = new RacingGame(InputView.numOfCars(), InputView.times());

        for (int i = 0; i < rg.getTimes(); i++) {
            rg.startGame();
            ResultView.gameResult(rg.getCars());
        }
    }

}
