package racinggame.mvc.domain;

public class Car {

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        if (position < 0) {
            throw new IllegalArgumentException("자동차 위치는 음수일 수 없습니다.");
        }

        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void move(int threshold) {
        if (threshold < 4) {
            return;
        }

        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
