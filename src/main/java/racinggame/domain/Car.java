package racinggame.domain;

public class Car {

    private String name;
    private Position position;

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void move(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("음수는 입력 할 수 없습니다.");
        }

        if (value >= 4) {
            position.move();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }
}
