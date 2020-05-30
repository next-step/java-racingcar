package racingcar;

public class RacingMain {
    public static void main(String[] args){
        int carNum = InputView.carNum();
        int tryNum = InputView.tryTime();

        Racing racing = new Racing(carNum, tryNum);
        racing.startRace();

        ResultView.results(racing.getRacingCar());
    }
}
