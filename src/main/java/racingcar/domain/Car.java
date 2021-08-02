package racingcar.domain;

public class Car {
    private int position = 1;
    private final String name;

    public Car(String name) {
        this.name = name;
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
