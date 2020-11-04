package study.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class RealCar implements Car {
    private final String name;
    private boolean moved;
    private final Random random;
    private final List<Boolean> drivingRecord = new ArrayList<>();

    public RealCar(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.random = new Random();
    }

    @Override
    public boolean isMoved() {
        return moved;
    }

    @Override
    public void move() {
        moved = guessMove();
        drivingRecord.add(moved);
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getTotalTry() {
        return drivingRecord.size();
    }

    private boolean guessMove() {
        return random.nextInt(10) >= 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RealCar realCar = (RealCar) o;
        return name.equals(realCar.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
