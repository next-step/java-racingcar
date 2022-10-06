package racingcar;

public class RacingCar {
    public static void main(String[] args) {
        RaceInput racingInput = new RaceInput();
        RaceController raceController = new RaceController(racingInput);
        System.out.println("실행 결과");
        raceController.startRacing();
    }
}
