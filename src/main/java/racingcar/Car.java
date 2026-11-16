package racingcar;

public class Car {


    private int position;



    public Car(int initPosition) {
        this.position = initPosition;
    }

    public void moveForward() {
        position++;
    }


    public int getPosition() {
        return position;
    }
}
