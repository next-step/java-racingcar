package step3;

public class CarRacing {
    public static void main(String[] args) {
        int carNum = InputView.printQuestion(InputView.Q_CAR_NUMBER);
        int tryNum = InputView.printQuestion(InputView.Q_TRY_TIMES);

        Cars cars = new Cars(carNum);
        ResultView.print_GameResult();

        for (int i = 0; i < tryNum; i++) {
            cars.playGame();
            ResultView.print_PlayResult(cars);
            System.out.println();
        }
    }
}
