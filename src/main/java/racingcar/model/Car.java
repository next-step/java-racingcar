package racingcar.model;

public class Car {

    private final static int MOVE_DISTANCE = 4;
    private int carLocation;

    public Car() {
        carLocation = 0;
    }

    public int carLocation() {
        return this.carLocation;
    }

    public void moveToFront(int inputValue){
        if(inputValue >= MOVE_DISTANCE){
            carLocation++;
        }
    }

}
