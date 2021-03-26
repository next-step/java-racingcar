package step4.domain;

import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int RANGE = 10;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(String name, int position) {
        this(new Name(name), new Position(position));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    // 프로그래밍 상 자연스러운 DI 구조
    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            position.plus();
        }
    }

    // 테스트 코드를 위한 메소드
    public void move(int randomValue) {
        // <= 형태보다 개인적으로 보기 편하다.
        if (randomValue >= FORWARD_NUM) {
            position.plus();
        }
    }

    // 테스트 코드를 위한 메소드
    public void move() {
        if (getRandomNo() >= FORWARD_NUM) {
            position.plus();
        }
    }

    protected int getRandomNo() {
        return new Random().nextInt(RANGE);
    }

    public boolean isMoving() {
        return position() > 0;
    }

    public int position() {
        return position.getPosition();
    }

    public Position getMaxPosition(Position maxPositon) {
        if (position.lessThan(maxPositon)) {
            return maxPositon;
        }
        return position;
    }

    public String name() {
        return name.getName();
    }

    public int bestScore(int grade) {
        if (position() > grade) {
            grade = position();
        }
        return grade;
    }

    public boolean isWinner(int grade) {
        return (grade == 0) ? false : position() == grade;
    }

    public boolean isWinner(Position maxPosition) {
        return position.equals(maxPosition);
    }
}
