package mission1.step4.domain.car;

import mission1.step4.algorithm.MoveStrategy;
import java.util.Objects;

public class Car {

    private String name;
    private int progress;

    private Car(String name){
        this.name = name;
    }

    public static Car create(String name) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("차량 생성시 이름은 필수 값 입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 초과할 수 없습니다.");
        }

        return new Car(name);
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            move();
        }
    }

    public boolean isWinnerCar(int otherProgress) {
        return this.progress == otherProgress;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }

    public Car copy() {
        Car car = new Car(this.name);
        car.progress = this.progress;

        return car;
    }

    private void move() {
        this.progress++;
    }
}








