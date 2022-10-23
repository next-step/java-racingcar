package step4;

public class RacingGame {

    public static void run() {
        Result result = new Result();
        Cars cars = new Cars();

        cars.addCars(InputRacingCar.inputNames());
        int times = InputRacingCar.inputTimes();

        OutputRacingCar.printTitle();
        Racing.racing(cars, times);
        OutputRacingCar.printResult(result.findWinner(cars));
    }
}
