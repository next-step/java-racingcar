package racingcar.ui;

public class InputView {
    private static InputView instance = new InputView();

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

    public void inputNumberOfCar() {
        System.out.println("자동차 대수는 몇 대 인가요?");
    }

    public void inputNumberOfAttempt() {
        System.out.println("시도할 회수는 몇 회 인가요?");
    }

}
