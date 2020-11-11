package racing.model;

public class RacingCar implements Car {
    private Name name;
    private static final int MOVEABLE_NUMBER = 4;
    private int location = 0;

    public RacingCar(String name){
        this.name = new Name(name);
    }

    @Override
    public void move(int fuel) {
        if (MOVEABLE_NUMBER <= fuel) {
            location++;
        }
    }

    @Override
    public int currentLocation() {
        return location;
    }

    public String getCarName() {
        return name.getName();
    }
}
