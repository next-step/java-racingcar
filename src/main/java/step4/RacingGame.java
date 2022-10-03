package step4;

public class RacingGame {

    public static void run() {
        InputRacingCar inputRacingCar = new InputRacingCar();
        Racing racing = new Racing();

        Car[] cars = inputRacingCar.inputCar();
        int times = inputRacingCar.inputTimes();

        racing.racing(cars, times);

    }
}
