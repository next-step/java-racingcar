package step3;

public class CarRacing {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carNum = inputView.printQuestion(InputView.Q_CAR_NUMBER);
        int tryNum = inputView.printQuestion(InputView.Q_TRY_TIMES);

        Cars cars = new Cars(carNum);
        resultView.print_GameResult();

        for (int i = 0; i < tryNum; i++) {
            cars.playGame();
            resultView.print_PlayResult(cars);
            System.out.println();
        }
    }
}
