package step3;

public class MainApplication {

    public static void main(String[] args) {

        // set new car
        int carCount = InputView.setCarsCount();
        // set play times.
        int tryTimes = InputView.setPlayCounts();

        RacingGame racingGame = new RacingGame(carCount, tryTimes);

        racingGame.play();

    }


}
