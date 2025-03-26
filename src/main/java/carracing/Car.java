package carracing;

public class Car {
    private String name;
    private int position;

    public Car() {
        this.name = "";
        this.position = 0;
    }

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }
}
