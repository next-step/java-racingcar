package racingcar;

public class Car {
    private int position = 1;
    private final String name;
    private final MovingStrategy movingStrategy;

    public Car(MovingStrategy movingStrategy, String name) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move(MovingStrategy movingStrategy) {
         if(movingStrategy.isMove()) {
             position ++;
         }
    }

}
