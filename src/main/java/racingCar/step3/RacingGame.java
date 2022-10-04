package racingCar.step3;

public class RacingGame {
    public static final String CAR_NAME_DELIMITER = ",";
    //    private final int numOfCars;
    private final RacingCar[] cars;
    private final int numOfRounds;

    private final ResultView printer;

    public RacingGame(InputView keyboardInput, ResultView printer) {
        this.cars = initializedCars(getCarNames(keyboardInput));
        this.numOfRounds = keyboardInput.numberOfRounds();
        this.printer = printer;
    }

    private static String[] getCarNames(InputView keyboardInput) {
        return keyboardInput.nameOfCars().split(CAR_NAME_DELIMITER);
    }

    public void start() {
        printer.print("실행 결과");

        for (int i = 0; i < numOfRounds; i++) {
            for (RacingCar car : cars) {
                car.tryMove();
            }

            printer.print(cars);
        }
    }

    private RacingCar[] initializedCars(String[] carNames) {
        RacingCar[] cars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new RacingCar(carNames[i], System.currentTimeMillis() + i);
        }

        return cars;
    }
}
