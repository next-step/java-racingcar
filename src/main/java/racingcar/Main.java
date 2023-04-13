package racingcar;

public class Main {

    public static void main(String[] args) {
        RacingCarSystem racingCarSystem = new RacingCarSystem();

        ResultView.registerNumberOfCars();
        int cars = InputView.registerNumberOfCars();
        racingCarSystem.registerCar(cars);

        ResultView.registerNumberOfMovements();
        int movements = InputView.registerNumberOfMovements();
        racingCarSystem.registerMovements(movements);

        ResultView.getRacingResult();
        for (int i = 0; i < movements; i++) {
            racingCarSystem.goOrStop();
            ResultView.getStatusOfCars(racingCarSystem.getStatusOfCars());
        }
    }
}
