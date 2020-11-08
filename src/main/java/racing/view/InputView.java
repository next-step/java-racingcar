package racing.view;

public class InputView {

    private final String INPUT_NUMBER_OF_CARS_MSG = "자동차 대수는 몇 대인가요?";
    private final String INPUT_RETRY_COUNT_MSG = "시도할 횟수는 몇 회인가요?";

    public void printNumberOfCars() {
        System.out.println(INPUT_NUMBER_OF_CARS_MSG);
    }

    public void printRetryCount() {
        System.out.println(INPUT_RETRY_COUNT_MSG);
    }


}
