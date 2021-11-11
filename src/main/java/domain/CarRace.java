package domain;

public class CarRace {
    private final String carName;
    private int position;

    public CarRace(String carName, int carPositing){
        this.carName = carName;
        this.position = carPositing;
    }

    public void positionAdd(int move) {
        position += move;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
