package step4;

public class RacingGame {

    public static void run() {
        InputRacingCar inputRacingCar = new InputRacingCar();
        OutputRacingCar outputResult = new OutputRacingCar();
        Racing racing = new Racing();
        Result result = new Result();
        Cars cars = new Cars();

        cars.addCars(inputRacingCar.inputNames());
        int times = inputRacingCar.inputTimes();

        outputResult.printTitle();
        racing.racing(cars, times, outputResult);
        outputResult.printResult(result.findWinner(cars));
    }
}
