package racingcar.domain;

public class RacingCarName {

    private final String name;

    public RacingCarName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
