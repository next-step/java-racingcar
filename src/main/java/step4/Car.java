package step4;

public class Car {


    // 구분
    private String carName;
    private int location;
    private int rank;
    private CarMoveStrategy carMoveStrategy;

    public Car(String carsName, int location, CarMoveRandomStrategy carMoveStrategy) {
        this.carName = carsName;
        this.location = location;
        this.carMoveStrategy = carMoveStrategy;
    }

    public void move() {
        this.location += carMoveStrategy.getMoveCount();
    }

    public String getCarName() {
        return carName;
    }

    public int getLocation() {
        return location;
    }


    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
