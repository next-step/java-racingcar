package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class Input {
    public int numberOfCar;
    public int numberOfCountToTry;

    private Input(int numberOfCar, int numberOfCountToTry) {
        this.numberOfCar = numberOfCar;
        this.numberOfCountToTry = numberOfCountToTry;
    }

    public List<RacingCar> toRacingCars() {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCar; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int numberOfCar;
        private int numberOfCountToTry;

        private Builder() {}

        public Builder numberOfCar(int numberOfCar) {
            this.numberOfCar = numberOfCar;
            return this;
        }

        public Builder numberOfCountToTry(int numberOfCountToTry) {
            this.numberOfCountToTry = numberOfCountToTry;
            return this;
        }

        public Input build() {
            return new Input(this.numberOfCar, this.numberOfCountToTry);
        }
    }
}
