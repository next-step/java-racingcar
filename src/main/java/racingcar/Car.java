package racingcar;

public class Car {
    public static final int MOVE_THRESHHOLD = 4;
    private String name;
    private int distance = 1;

    public Car() {
    }

    public Car(Car car) {
        this.name = car.name;
        this.distance = car.distance;
    }

    public Car(String name) {
        this.name = name;
    }

    public void go(int random){
        if(isMove(random)) {
            distance++;
        }
    }

    public boolean isMove(int random){
        return random >= MOVE_THRESHHOLD;
    }

    public int getDistance() {
        return distance;
    }

    public boolean equalDistance(int distance){
        return this.distance == distance;
    }

    public CarSnapshot snapshot(){
        return new CarSnapshot(this);
    }

    public String getName() {
        return name;
    }


}
