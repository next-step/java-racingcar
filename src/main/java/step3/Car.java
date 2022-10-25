package step3;


public class Car {
    private final int CAR_MOVE = 1;
    private final int MINUMUN_SPEED = 4;
    private final int START_POINT = 0;
    private int distance;
    public String name;

    public Car(String name) {
        this.distance = START_POINT;
        this.name = name;
    }

    public Car(int distance,String name) {
        this.distance = distance;
        this.name = name;
    }

    public void move() {
        int speed = Engine.getSpeed();
        if(speed >= MINUMUN_SPEED){
            distance += CAR_MOVE; //전진
        }
    }
    public int getDistance() {
        return distance;
    }

}
