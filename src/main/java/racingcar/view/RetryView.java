package racingcar.view;

public class RetryView {

    private static final String RETRY_MESSAGE = "1 이상의 숫자만 입력해 주세요.";

    private RetryView() {
    }

    public static int retryIfInputNegativeNumber(View inputView) {
        int number;

        try {
            number = Integer.parseInt(inputView.input());
        } catch (NumberFormatException e) {
            System.out.println(RETRY_MESSAGE);
            return retryIfInputNegativeNumber(inputView);
        }

        if (isZeroOrNegative(number)) {
            System.out.println(RETRY_MESSAGE);
            return retryIfInputNegativeNumber(inputView);
        }

        return number;
    }

    private static boolean isZeroOrNegative(int number) {
        return number <= 0;
    }
}
