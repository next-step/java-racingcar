package racingcar;

public class Car {


    public static final int DEFAULT_INIT_POSITION = 0;
    private int position;



    public Car(int initPosition) {
        this.position = initPosition;
    }

    public Car() {
        this(DEFAULT_INIT_POSITION);
    }

    public void moveForward() {
        position++;
    }


    public int getPosition() {
        return position;
    }
}


