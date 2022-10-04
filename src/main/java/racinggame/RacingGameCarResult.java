package racinggame;

import java.util.Objects;

public class RacingGameCarResult {

    private final String name;
    private final int position;

    public RacingGameCarResult(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static RacingGameCarResult from(Car car) {
        return new RacingGameCarResult(car.getName(), car.getPosition());
    }

    public String getName() {
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
