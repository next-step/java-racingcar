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

    public static RacingCar copy(RacingCar car) {
        return new NamedRacingCar(car.toString(), car.getPosition());
    }

    @Override
    public String toString() {
        return name;
    }
}
