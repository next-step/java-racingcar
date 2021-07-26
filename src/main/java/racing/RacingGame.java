package racing;

public class RacingGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int carCount = inputView.readCarCount();
        int moveCount = inputView.readMoveCount();

        Racing racing = new Racing(carCount, moveCount);

        outputView.startPrintResult();
        while(!racing.isEnd()){
            CarsDTO carsDTO = racing.play();
            outputView.printResult(carsDTO);
        }
    }
}
