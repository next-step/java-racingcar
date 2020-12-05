package racing.domain;

import racing.view.OutputView;

import java.util.Objects;

public class RacingGame {
    private final int repeatCount;
    private Cars cars;

    public RacingGame(int carCount, int repeatCount, PowerGenerator powerGenerator) {
        this.repeatCount = repeatCount;
        this.cars = new Cars(carCount, powerGenerator);
    }

    RacingGame(Cars cars, int repeatCount) {
        this.cars = cars;
        this.repeatCount = repeatCount;
    }

    public void start() {
        OutputView.printTitle();

        for (int i = 0; i < repeatCount; i++) {
            cars.move();
            OutputView.printResult(this.cars);
        }
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
