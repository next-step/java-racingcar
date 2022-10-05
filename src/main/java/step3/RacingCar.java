package step3;

public class RacingCar {
    public static void main(String[] args) {
        RaceInput racingInput = new RaceInput();
        RaceController raceController = new RaceController(racingInput);
        raceController.startRacing();
    }
}
