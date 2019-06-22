package racingcar;

import racingcar.model.Cars;
import racingcar.model.InputModel;

import java.util.List;

public class RacingMain {
    public static void main(String[] args) {
        InputModel inputVal = InputView.getInput();
        int carNum = inputVal.getCarNum();
        int times = inputVal.getTimes();

        NumGenerator randomNum = new RandomNumGenerator();
        RacingGame racingGame = new RacingGame(times, carNum, randomNum);
        List<Cars> result = racingGame.run();

        new ResultView().print(result);


    }
}


