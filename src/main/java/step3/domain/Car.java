package step3.domain;

public class Car {

    private final static int MOVE_STANDARD_NUM = 4;
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomNum) {
        if(randomNum >= MOVE_STANDARD_NUM) {
            distance++;
        }
    }

}
