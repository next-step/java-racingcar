package domain;

import java.util.*;
import view.ResultView;
import java.util.function.Supplier;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final StringBuilder position = new StringBuilder();
    private static final Random random = new Random();
    private final Supplier<Integer> randomSupplier;
    private final String name;



    public Car(String name) {
        this.name = name;
        this.randomSupplier = () -> new Random().nextInt(10); // 기본 랜덤 값 생성

    }

    public static void validateCarName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
        }
    }

    public void move() {
        if (randomSupplier.get()>= MOVE_THRESHOLD) {
            ResultView.printCarString(position);
        }
    }

    public String getPosition() {
        return position.toString();
    }
    public String getName() {
        return name;
    }


    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
