package racing;

public class Car {

    private static final Integer DEFAULT_POSITION = 0;
    private static final Integer MAX_RANDOM = 9;
    private static final Integer NAME_LENGTH_CRITERIA = 5;
    private static final Integer MOVE_CRITERIA = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public Car(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    private static void validateName(String name) {
        if (name.length() > NAME_LENGTH_CRITERIA) {
            throw new RuntimeException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > MAX_RANDOM) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= MOVE_CRITERIA) {
            position += 1;
        }
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }

    public int position() {
        return position;
    }

    public String name() {
        return name;
    }
}
