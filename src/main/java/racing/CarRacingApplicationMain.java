package racing;

public class CarRacingApplicationMain {
    public static void main(String[] args) {
        Race race = InputView.createRace();
        race.play();
        OutputView.showResult(race);
    }
}
