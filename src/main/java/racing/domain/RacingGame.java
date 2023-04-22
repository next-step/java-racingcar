package racing.domain;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private final int turns;

    public RacingGame(String inputNames, int turn) {

        this.turns = turn;
        String[] names = inputNames.split(",");

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Car(0, names[i]));
        }
        this.cars = new Cars(list);
    }

    public List<Cars> playGame() {

        List<Cars> results = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            results.add(this.cars.playOnceTurn());
        }

        return results;
    }

    public List<String> winners() {
        return this.cars.findWinners();
    }

}
