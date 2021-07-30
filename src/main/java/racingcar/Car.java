package racingcar;

public class Car {
    private int position = 1;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
         if(Math.random() * 10 >= moveCount) {
             position ++;
         }
    }
}
