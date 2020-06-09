package step4;

import java.util.Objects;

public class Game {

    private Cars cars;
    private int round;

    public Game(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public Result start() {
        return cars.move(new Fuel());
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
