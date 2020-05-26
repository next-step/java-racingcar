package step4;

public class MainApplication {

    public static void main(String[] args) {

        // set new car
        String[] carsNames = InputView.setCarsNames();

        // set play times.
        int tryTimes = InputView.setPlayCounts();

        RacingGame racingGame = new RacingGame(carsNames, tryTimes);

        racingGame.play();

    }


}
