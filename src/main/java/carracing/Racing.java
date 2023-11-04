package carracing;

import carracing.ui.InputView;

public class Racing {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCount = InputView.inputCarCount();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int tryCount = InputView.inputTryCount();
    }
}
