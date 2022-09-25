package step3;

public class CarRacing {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        inputView.printQ_CarNumber();
        int carNum = inputView.inputNumber();
        Cars cars = new Cars(carNum);

        inputView.printQ_TryTimes();
        int tryNum = inputView.inputNumber();

        resultView.print_GameResult();

        for (int i=0; i<tryNum; i++) {
            cars.playGame();
            resultView.print_PlayResult(cars);
            System.out.println();
        }
    }
}
