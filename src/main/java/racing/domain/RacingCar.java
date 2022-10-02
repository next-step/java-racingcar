package racing.domain;

import java.util.Objects;

public class RacingCar {

    public static final int DEFAULT = 0;

    private CarName name;
    private int position;

    public RacingCar(final CarName carName, final int position) {

        this.name = carName;
        this.position = position;
    }

    public RacingCar(final CarName carName) {

        this(carName, DEFAULT);
    }

    public void move() {

        this.position++;
    }

    public CarName getName() {

        return this.name;
    }

    public int getPosition() {

        return this.position;
    }

    public String convert() {

        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(name, racingCar.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}