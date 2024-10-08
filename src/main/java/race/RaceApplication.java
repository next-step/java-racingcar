package race;

public class RaceApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        String carNames = inputView.askCarNames();
        Cars cars = new Cars(carNames.split(","));
        Round round = inputView.askRoundCount();

        Race race = new Race(cars, round);
        race.run();
    }
}
