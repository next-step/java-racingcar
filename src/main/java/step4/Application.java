package step4;

import step4.model.Cars;
import step4.model.Race;
import step4.view.InputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = InputView.getCars();
        int rounds = InputView.getRounds();
        Race race = new Race(cars, rounds);
        race.start();
    }
}
