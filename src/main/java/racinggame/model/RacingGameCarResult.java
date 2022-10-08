package racinggame.model;

import racinggame.domain.Car;
import racinggame.domain.CarName;

import java.util.Objects;

public class RacingGameCarResult {

    private final CarName name;
    private final int position;

    public RacingGameCarResult(CarName name, int position) {
        this.name = name;
        this.position = position;
    }

    public RacingGameCarResult(String name, int position) {
        this(new CarName(name), position);
    }

    public static RacingGameCarResult from(Car car) {
        return new RacingGameCarResult(car.getName(), car.getPosition());
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameCarResult racingGameCarResult = (RacingGameCarResult) o;
        return position == racingGameCarResult.position && Objects.equals(name, racingGameCarResult.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
