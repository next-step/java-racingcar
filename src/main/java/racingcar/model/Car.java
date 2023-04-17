package racingcar.model;

public class Car {

    private int carLocation;

    public Car() {
        carLocation = 0;
    }

    public int carLocation() {
        return this.carLocation;
    }

    public void move(){
        carLocation++;
    }

}
