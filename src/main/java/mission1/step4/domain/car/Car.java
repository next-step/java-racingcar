package mission1.step4.domain.car;

import mission1.step4.algorithm.MoveStrategy;
import mission1.step4.util.CarUtil;

import java.util.Objects;

public class Car {

    private String name;
    private MoveStrategy moveStrategy;
    private int progress;

    private Car(String name, MoveStrategy moveStrategy){
        this.name = name;
        this.moveStrategy = moveStrategy;
    };

    public static Car create(String name, MoveStrategy moveStrategy) {
        if (Objects.isNull(name) || name.trim().isEmpty()) {
            throw new IllegalArgumentException("차량 생성시 이름은 필수 값 입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("차량 이름은 5자를 초과할 수 없습니다.");
        }

        if (Objects.isNull(moveStrategy)) {
            throw new IllegalArgumentException("차량의 이동전략 선택은 필수 입니다.");
        }

        return new Car(name, moveStrategy);
    }

    public void move(int randomValue) {
        if (moveStrategy.movable(randomValue)) {
            progress++;
        }
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}






