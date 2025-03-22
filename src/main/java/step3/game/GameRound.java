package step3.game;

import java.util.List;
import java.util.Objects;

public class GameRound {
    private final List<Car> result;

    public GameRound(List<Car> cars) {
        this.result = CarFactory.copyCars(cars);
    }

    public List<Car> getRound() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameRound that = (GameRound) o;

        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return result.hashCode();
    }
}
