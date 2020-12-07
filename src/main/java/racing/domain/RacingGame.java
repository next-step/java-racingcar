package racing.domain;

import racing.Results;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingGame {
    private final int repeatCount;
    private final Cars cars;

    public RacingGame(String carNames, int repeatCount, PowerGenerator powerGenerator) {
        this.repeatCount = repeatCount;
        this.cars = new Cars(carNames, powerGenerator);
    }

    RacingGame(Cars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = repeatCount;
    }

    public Results play() throws CloneNotSupportedException {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < repeatCount; i++) {
            cars.move();
            results.add(new Result(cars));
        }

        return new Results(results);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return repeatCount == that.repeatCount &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(repeatCount, cars);
    }
}
