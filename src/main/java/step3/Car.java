package step3;

public class Car {

    public Car(int moveNumber) {
        this.moveNumber = moveNumber;
    }

    private int distance = 0;
    private int moveNumber;

    public void move(int randomNum) {

        if(randomNum >= moveNumber) {
            distance ++;
        }
    }

    public int getDistance() {
        return distance;
    }

}
