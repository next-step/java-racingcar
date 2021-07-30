package racing.model;


public class Car {

    private static final int MINIMUM_CONDITION = 4;
    private static final int MAXIMUM_CONDITION = 9;

    private CarInfo carInfo;
    private int distance;

    public Car(String carName) {
        this.carInfo = new CarInfo(carName);
    }

    public Car(String carName, int distance) {
        this.carInfo = new CarInfo(carName);
        this.distance = distance;
    }

    public int totalDistance() {
        return this.distance;
    }

    public boolean run(int move) {
        if(moveCondition(move)) {
            this.distance++;
            return true;
        }
        return false;
    }

    public Boolean moveCondition(int randomValue) {
        if(randomValue > MAXIMUM_CONDITION) {
            throw new IllegalStateException();
        }
        if(randomValue >= MINIMUM_CONDITION && randomValue <= MAXIMUM_CONDITION) {
            return true;
        }
        return false;
    }


    public Boolean checkDistance(int distance) {
        return this.distance == distance;
    }

    public String carName() {
        return this.carInfo.name();
    }
}
