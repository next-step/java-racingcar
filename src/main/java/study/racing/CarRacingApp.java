package study.racing;

public class CarRacingApp {

    public static void main(String... args) {

        InputView inputView = new InputView();
        RacingInput racingInput = inputView.getRacingInput();

        CarRacing cr = new CarRacing(racingInput, new ResultView());
        cr.run();
    }

}
