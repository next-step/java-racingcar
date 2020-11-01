package racingcar.dto;

import racingcar.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;

public class Input {
    public final List<String> namesOfCars;
    public final int numberOfCountToTry;

    private Input(List<String> namesOfCars, int numberOfCountToTry) {
        this.namesOfCars = namesOfCars;
        this.numberOfCountToTry = numberOfCountToTry;
    }

    public List<RacingCar> toRacingCars() {
        return namesOfCars.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<String> namesOfCars;
        private int numberOfCountToTry;

        private Builder() {}

        public Builder numberOfCar(List<String> namesOfCars) {
            this.namesOfCars = namesOfCars;
            return this;
        }

        public Builder numberOfCountToTry(int numberOfCountToTry) {
            this.numberOfCountToTry = numberOfCountToTry;
            return this;
        }

        public Input build() {
            return new Input(this.namesOfCars, this.numberOfCountToTry);
        }
    }
}
