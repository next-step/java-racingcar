package racing.domain;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private final int turns;
    private final GameRule rule;

    public RacingGame(String inputNames, int turn, GameRule rule) {

        this.turns = turn;
        String[] names = inputNames.split(",");

        List<Car> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            list.add(new Car(0, names[i]));
        }
        this.cars = new Cars(list);
        this.rule = rule;
    }

    public List<Cars> playGame() {

        List<Cars> results = new ArrayList<>();
        for (int i = 0; i < turns; i++) {
            results.add(this.cars.playOnceTurn(this.rule));
        }

        return results;
    }

    public List<String> winners() {
        return this.cars.findWinners();
    }

}
