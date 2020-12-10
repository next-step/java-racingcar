package racingcar;

public class NamedRacingCar extends RacingCar{

    private String name;

    public NamedRacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
