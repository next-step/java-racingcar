import step3.view.InputView;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String carNumber = inputView.carNumberInput();
        String attemptNumber = inputView.attemptNumberInput();

        System.out.println("car Number : " + carNumber + " attempt Number : " + attemptNumber);

    }
}
