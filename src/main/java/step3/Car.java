package step3;

public class Car {

    private int distance = 0;
    private int moveNumber;

    public Car(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    public void move(int randomNum) {
        if(randomNum >= moveNumber) {
            distance ++;
        }
    }

    public int getDistance() {
        return distance;
    }
}
