package race.vehicle;

import java.util.Random;

public class Car {
    private StringBuffer location;

    Car(Builder builder) {
        this.location = builder.location;
    }

    public void move() {
        Random random = new Random();
        if (random.nextInt(10) >= 4) {
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
