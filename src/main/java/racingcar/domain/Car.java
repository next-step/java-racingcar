package racingcar.domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.moveAble()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int selectMaxPosition(int maxPosition) {
        if (this.getPosition() > maxPosition) {
            maxPosition = this.getPosition();
        }
        return maxPosition;
    }

    public boolean isCarAtMaxPosition(int maxPosition) {
        return maxPosition == this.getPosition();
    }
}
