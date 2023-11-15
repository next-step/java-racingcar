package racing.domain;

public class Car {

    private static final int ACCEPT_MOVE_NUMBER = 4;

    private final String name;
    private int position;

    public Car(final String name, final int position) {
        this.name = checkName(name);
        this.position = position;
    }

    private String checkName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자를 넘을 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 1자 이상이여야 합니다.");
        }
        return name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void tryMove(int number) {
        if (number >= ACCEPT_MOVE_NUMBER) {
            position++;
        }
    }
}
