package step3.view;

import step3.domain.RacingInformation;

import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);
    private final static String ZERO_INPUT_USER_GUIDE = "0보다 큰수를 입력해주세요 :(";
    private final static String REQUEST_NUMBER_OF_CAR_GUIDE = "자동차 대수는 몇 대 인가요?";
    private final static String REQUEST_NUMBER_OF_TRY = "시도할 회수는 몇 회 인가요?";
    private final static int ONE = 1;

    private InputView() {
    }

    private static class InputViewInstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewInstanceHolder.INSTANCE;
    }

    public int requestNumberOfCar() {
        return showPrompt(REQUEST_NUMBER_OF_CAR_GUIDE);
    }

    public int requestNumberOfTry() {
        return showPrompt(REQUEST_NUMBER_OF_TRY);
    }

    private int showPrompt(String requestPrompt) {
        System.out.println(requestPrompt);
        return scanner.nextInt();
    }

    public RacingInformation execute() {

        int numberOfCars = requestNumberOfCar();
        validateLessThanOne(numberOfCars);
        int numberOfReps = requestNumberOfTry();
        validateLessThanOne(numberOfReps);

        return RacingInformation.of(numberOfCars, numberOfReps);
    }

    private void validateLessThanOne(int number) {
        if (number < ONE) {
            throw new IllegalArgumentException(ZERO_INPUT_USER_GUIDE);
        }
    }

}
