package racing.model;

public class NamedRacingCar extends RacingCar {

    private String name;

    public NamedRacingCar(String name) {
        this.name = name;
    }

    public NamedRacingCar(RacingCar racingCar) {
        super(racingCar);
        name = racingCar.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
