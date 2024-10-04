package race;

public class RaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int carCount = inputView.askCarCount();
        int roundCount = inputView.askRoundCount();

        Race race = new Race(carCount, roundCount);
        race.run();
    }
}
