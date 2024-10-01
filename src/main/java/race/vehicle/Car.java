package race.vehicle;

import race.Utils.Generator;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private static final int BOUND = 10;
    public static final String INITIAL_LOCATION = "-";

    private StringBuffer location = new StringBuffer(INITIAL_LOCATION);
    private Generator generator;

    Car(Builder builder) {
        this.generator = builder.generator;
    }

    public void move() {
        if (generator.getValue(BOUND) >= MOVE_CONDITION) {
            location.append("-");
        }
    }

    public String getLocation() {
        return this.location.toString();
    }

    public static class Builder {
        private StringBuffer location;
        private Generator generator;

        public Builder initlocation(String input) {
            this.location = new StringBuffer(input);
            return this;
        }

        public Builder initGenerator(Generator generator) {
            this.generator = generator;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
