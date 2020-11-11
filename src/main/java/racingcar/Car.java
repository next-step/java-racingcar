package racingcar;

public class Car {
    public static final int MOVE_THRESHHOLD = 4;
    private int distance = 1;

    public Car() {
    }
    public Car(int distance) {
        this.distance = distance;
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

    public CarSnapshot snapshot(){
        return new CarSnapshot(distance);
    }



}
