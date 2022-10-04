package step4;

import java.util.List;

public class RacingGame {

    public static void run() {
        InputRacingCar inputRacingCar = new InputRacingCar();
        OutputRacingCar outputResult = new OutputRacingCar();
        Racing racing = new Racing();
        Result result = new Result();

        List<Car> cars = inputRacingCar.inputCar();
        int times = inputRacingCar.inputTimes();

        outputResult.printTitle();
        racing.racing(cars, times, outputResult);
        result.findWinner(cars);
        outputResult.printResult(result.getWinner());

    }
}
