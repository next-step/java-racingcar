package racing.model;

public class NamedRacingCar extends RacingCar {

    private String name;

    public NamedRacingCar(String name) {
        this(name, 0);
    }

    public NamedRacingCar(String name, int position) {
        super(position);
        this.name = name;
    }

    @Override
    public NamedRacingCar copy() {
        return new NamedRacingCar(name, position);
    }

    @Override
    public String toString() {
        return name;
    }
}
