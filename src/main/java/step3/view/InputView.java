package step3.view;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String REQUEST_NUMBER_OF_CAR_GUIDE = "자동차 대수는 몇 대 인가요?";
    private final static String REQUEST_NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";
    private final static String ZERO_NUMBER_USER_GUIDE = "0 이상 입력해주세요";
    private final static int ZERO = 0;

    private int numberOfCars;
    private int numberOfReps;

    public void requestNumberOfCar() {
        System.out.println(REQUEST_NUMBER_OF_CAR_GUIDE);
        numberOfCars = scanner.nextInt();
        validateZeroNumber(numberOfCars);
    }

    public void requestNumberOfTry() {
        System.out.println(REQUEST_NUMBER_OF_TRY);
        numberOfReps = scanner.nextInt();
        validateZeroNumber(numberOfReps);

    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getNumberOfReps() {
        return numberOfReps;
    }

    private void validateZeroNumber(int number) {
        if (number == ZERO) {
            throw new IllegalArgumentException(ZERO_NUMBER_USER_GUIDE);
        }
    }
}
