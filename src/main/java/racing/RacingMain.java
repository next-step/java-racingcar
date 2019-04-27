package racing;

public class RacingMain {
    public static void main(String[] args) {
        int carNum = InputView.inputCarNum();
        int tryTime = InputView.inputTryTime();

        Racing racing = new Racing(carNum, tryTime);
        racing.startRace();

        ResultView.printCars(racing.getRacingCars());
    }
}
