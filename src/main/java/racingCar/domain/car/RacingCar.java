package racingCar.domain.car;

import java.util.Objects;

public class RacingCar {
    private final String name;
    private int position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean isMove) {
        if(isMove) {
            position++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return position == racingCar.position &&
                Objects.equals(name,racingCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,position);
    }
}
