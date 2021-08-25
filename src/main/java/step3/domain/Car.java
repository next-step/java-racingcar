package step3.domain;

public class Car {

    private static int moveNumber = 4;
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int randomNum) {
        if(randomNum >= moveNumber) {
            distance++;
        }
    }

}
