package racingcar.domain;

public class Car {
    private static final int MOVE_CONDITION = 4;
    private CarName carName;
    private CarLocation location;

    public Car(String name) throws Exception {
        this.carName = new CarName(name);
        this.location = new CarLocation();
    }

    public Car(String name, int location) throws Exception {
        this.carName = new CarName(name);
        this.location = new CarLocation(location);
    }

    public void move(int condition) {
        if (condition >= MOVE_CONDITION) {
            location.increase();
        }
    }

    public boolean isWinner(int max){
        return location.isMaxLocation(max);
    }

    public int checkMaxLocation(int carLocation){
        return location.checkMaxLocation(carLocation);
    }

    public int getCarLocation() {
        return location.getLocation();
    }

    @Override
    public String toString() {
        return carName.toString();
    }
}
