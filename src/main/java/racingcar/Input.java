package racingcar;

public class Input {
    public int numberOfCar;
    public int numberOfCountToTry;

    private Input(int numberOfCar, int numberOfCountToTry) {
        this.numberOfCar = numberOfCar;
        this.numberOfCountToTry = numberOfCountToTry;
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
