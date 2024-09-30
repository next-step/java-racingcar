package race.vehicle;

import race.Utils.RandomUtil;

public class Car {
    public static final int MOVE_CONDITION = 4;
    public static final int BOUND = 10;

    private StringBuffer location;

    Car(Builder builder) {
        this.location = builder.location;
    }

    public void move() {
        if (RandomUtil.getValue(BOUND) >= MOVE_CONDITION) {
            location.append("-");
        }
        System.out.println(location);
    }

    public static class Builder {
        private StringBuffer location;

        public Builder initlocation(String input) {
            location = new StringBuffer(input);
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
