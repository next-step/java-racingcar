package racing;

public class RacingMain {
    public static void main(String[] args) {
        String carNames[] = InputView.getNames();
//        int carNum = InputView.inputCarNum();
        int tryTime = InputView.inputTryTime();

        Racing racing = new Racing(carNames, tryTime);
//        racing.startRace();
//        ResultView.printCars(racing.getRacingCar());
    }
}
