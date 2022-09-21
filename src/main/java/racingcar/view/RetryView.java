package racingcar.view;

public class RetryView {

    private RetryView() {
    }

    public static int retryIfInputNegativeNumber(View inputView) {
        int number = Integer.parseInt(inputView.input());

        if (number < 0) {
            return retryIfInputNegativeNumber(inputView);
        }

        return number;
    }
}
