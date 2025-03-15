package racing;

public class RacingGame {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static void main(String[] args) {
        int carCount = InputView.getIntegerInput(CAR_COUNT_MESSAGE);
        int attemptCount = InputView.getIntegerInput(ATTEMPT_COUNT_MESSAGE);

        Car testCar = new Car(2);
        OutputView.printCarPosition(testCar);
    }

}
