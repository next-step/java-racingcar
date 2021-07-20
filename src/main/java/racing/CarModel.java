package racing;

public class CarModel {

    private int carNumber;
    private String raceDistance;

    public CarModel(int carNumber) {
        this.carNumber = carNumber;
    }

    public String getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(String raceDistance) {
        this.raceDistance = raceDistance;
    }
}
