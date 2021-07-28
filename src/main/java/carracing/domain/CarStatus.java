package carracing.domain;

public class CarStatus {

    private final CarName carName;
    private final int position;

    public CarStatus(CarName carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualToPosition(int position) {
        return this.position == position;
    }
}
