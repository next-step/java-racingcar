package racingcar;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        String carNames;
        int count;

        carNames = inputView.getCarNames();
        count = inputView.getTryNo();

        Racing racing = new Racing(carNames, count);

        System.out.println("실행 결과");

        while (!racing.isEnd()) {
            racing.startRacing();
            resultView.printCars(racing.getCars());
        }

        resultView.printWinners(racing.getWinners());
    }
}
