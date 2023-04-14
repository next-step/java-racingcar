package racing;

public class Car {

    private static final Integer DEFAULT_POSITION = 0;
    private static final Integer MOVE_CRITERIA = 4;
    private static final Integer MAX_RANDOM = 9;

    private int position;

    public Car() {
        this.position = DEFAULT_POSITION;
    }

    public void move(int randomNumber) {
        if (randomNumber < 0 || randomNumber > MAX_RANDOM) {
            throw new RuntimeException("랜덤값 경계를 벗어났습니다.");
        }
        if (randomNumber >= MOVE_CRITERIA) {
            position += 1;
        }
    }

    public int position() {
        return position;
    }
}
