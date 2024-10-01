package race.vehicle;

import race.Utils.NumberGenerator;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int BOUND = 10;
    public static final String INITIAL_LOCATION = "-";

    private StringBuffer location = new StringBuffer(INITIAL_LOCATION);
    private NumberGenerator numberGenerator;

    Car(Builder builder) {
        this.numberGenerator = builder.numberGenerator;
    }

    public void move() {
        if (numberGenerator.getValue(BOUND) >= MOVE_CONDITION) {
            location.append("-");
        }
    }

    public String getLocation() {
        return this.location.toString();
    }

    public static class Builder {
        private StringBuffer location;
        private NumberGenerator numberGenerator;

        public Builder initlocation(String input) {
            this.location = new StringBuffer(input);
            return this;
        }

        public Builder initGenerator(NumberGenerator numberGenerator) {
            this.numberGenerator = numberGenerator;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
