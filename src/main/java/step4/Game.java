package step4;

import java.util.ArrayList;
import java.util.Objects;

public class Game {

    private Cars cars;
    private int round;

    public Game(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public Result start(Fuel fuel) {
        return new Result(new ArrayList<>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return round == game.round &&
                Objects.equals(cars, game.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, round);
    }


}
