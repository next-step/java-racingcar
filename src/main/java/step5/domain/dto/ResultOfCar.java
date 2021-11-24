package step5.domain.dto;

public class ResultOfCar {
    private final String carName;
    private final int position;

    public ResultOfCar(String carName, int position) {
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
