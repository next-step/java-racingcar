package RacingCar;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        int carCount = inputView.carCount();
        int round = inputView.round();

        Racing racing = new Racing(carCount, round);
        ResultView resultView = new ResultView();

        resultView.resultView();
        for (int i = 0; i < racing.getRound(); i++) {
            racing.round();
            resultView.roundView(racing.getCarList());
        }
    }
}
