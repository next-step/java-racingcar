package racingcar;

import racingcar.model.Car;
import racingcar.model.InputModel;

import java.util.List;

public class RacingMain {


    public static void main(String[] args) {
        InputModel inputVal = new InputView().getInput();
        int carNum = inputVal.getCarNum();
        int times = inputVal.getTimes();

        NumGenerator randomNum = new RandomNumGenerator();
        RacingGame racingGame = new RacingGame(times, carNum, randomNum);
        List<List<Car>> result = racingGame.run();

        new ResultView().print(result);


    }
}
