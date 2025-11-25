package racingGame;

public class Car {

    private final CarName name;
    private Position position;

    public Car(String name) {
        this(new CarName(name));
    }

    Car(CarName name) {
        this.name = name;
        this.position = Position.ZERO;
    }

    public void move(MoveStrategy strategy) {
        if (strategy.isMove()) {
            position = position.move();
        }
    }

    // 외부(API/뷰/테스트)용 조회 메서드
    public int position() {
        return position.value();
    }

    public String name() {
        return name.value();
    }

    public int max(int currentMax) {
        return position.max(currentMax);
    }

    public boolean isSame(int max) {
        return position.isSame(max);
    }
}
