package race.vehicle;

import race.Utils.RandomUtil;

public class Car {
    public static final int MOVE_CONDITION = 4;
    public static final int BOUND = 10;

    private StringBuffer location;
    private RandomUtil randomUtil;

    Car(Builder builder) {
        this.location = builder.location;
        this.randomUtil = builder.randomUtil;
    }

    public void move() {
        if (randomUtil.getRandomValue(BOUND) >= MOVE_CONDITION) {
            location.append("-");
        }
        System.out.println(location);
    }

    public static class Builder {
        private StringBuffer location;
        private RandomUtil randomUtil;

        public Builder initlocation(String input) {
            this.location = new StringBuffer(input);
            return this;
        }

        public Builder initRandomUtil(RandomUtil randomUtil) {
            this.randomUtil = randomUtil;
            return this;
        }

        public Car build() {
            return new Car(this);
        }

    }
}
