package race;

public class RaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.askCarNames();
        Cars cars = new Cars(carNames.split(","));
        int roundCount = inputView.askRoundCount();

        Race race = new Race(cars, roundCount);
        race.run();
    }
}
