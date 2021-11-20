package step4.domain.dto;

public class ResultOfCar {
    private String carName;
    private int position;

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
