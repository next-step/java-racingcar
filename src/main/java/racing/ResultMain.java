package racing;

import racing.component.RacingGame;
import racing.dto.Car;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultMain {


    public static void main(String[] args) {

        InputView iv = new InputView();
        RacingGame rg = new RacingGame(iv.numOfCars(), iv.times());
        ResultView rv = new ResultView();

        for (int i = 0; i < rg.getTimes(); i++) {
            rg.startGame();
            rv.gameResult(rg.getCars());
        }
    }

}
