package carRacing;


public class Car {

    private int position;

    int go(CarMovingStrategy carMovingStrategy) {
        return carMovingStrategy.isMove() ? ++position : position;
    }
}
