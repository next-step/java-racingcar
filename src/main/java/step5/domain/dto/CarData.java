package step5.domain.dto;

public class CarData {
    private final String carName;
    private final int position;

    public CarData(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
