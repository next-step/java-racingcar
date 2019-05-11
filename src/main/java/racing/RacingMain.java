package racing;

public class RacingMain {
    public static void main(String[] args) {
        String[] carNames = InputView.getNames();
        int tryTime = InputView.inputTryTime();
        Racing racing = new Racing(carNames);
        ResultView.executeResult();
        for(int i = 0 ; i< tryTime ; i++){
            ResultView.printMoveCar(racing.onceMove());
        }
        ResultView.printWinners(racing.whoIsWin());
    }
}
