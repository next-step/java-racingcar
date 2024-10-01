package racingcar;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int competitors = inputView.getCompetitors();
        int forwardAttempts = inputView.getAttemptCount();
    }
}
