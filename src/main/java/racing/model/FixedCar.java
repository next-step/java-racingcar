package racing.model;

public class FixedCar {

    private final CarPosition position;
    private final CarName name;

    public FixedCar(String name, int position) {
        this.position = new CarPosition(position);
        this.name = new CarName(name);
    }

    public FixedCar(CarName name, CarPosition position) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public int max(int position) {
        return this.position.max(position);
    }

    public boolean isPosition(int position) {
        return this.position.isPosition(position);
    }
}
