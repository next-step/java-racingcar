package step3;

public class RaceApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputValues();

        Cars cars = new Cars(inputView.howManyCars(), inputView.getAttemps());

        ResultView resultView = new ResultView();
        resultView.getResult(inputView.getAttemps(), cars);
    }
}
