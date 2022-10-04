package racingCar.step3;

public class RacingGame {
    private final int numOfCars;
    private final int numOfRounds;

    private final ResultView printer;

    public RacingGame(InputView keyboardInput, ResultView printer) {
        this.numOfCars = keyboardInput.numberOfCars();
        this.numOfRounds = keyboardInput.numberOfRounds();
        this.printer = printer;
    }

    public void start() {
        RacingCar[] cars = initializedCars(numOfCars);

        printer.print("실행 결과");

        for (int i = 0; i < numOfRounds; i++) {
            for (RacingCar car : cars) {
                car.tryMove();
            }

            printer.print(cars);
        }
    }

    private RacingCar[] initializedCars(int numOfCars) {
        RacingCar[] cars = new RacingCar[numOfCars];
        for (int i = 0; i < numOfCars; i++) {
            cars[i] = new RacingCar(System.currentTimeMillis() + i);
        }

        return cars;
    }
}
