package racing.car.car;

public class Car implements Movable {

    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private final String OVER_MESSAGE_ERROR = "자동차 이름이 5자글자를 초과하였습니다.";
    private int position;

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    // 생성자에서 name을 반드시 받도록 강제
    public Car(String name, int position) {
        checkName(name);
        this.name = name;
        this.position = position;
    }

    @Override
    public void move(int number) {
        if (isMoveAllowed(number)) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public boolean isSame(int max) {
        return max == position;
    }

    public String getName() {
        return name;
    }

    private boolean isMoveAllowed(int number) {
        return number >= MOVE_THRESHOLD;
    }

    private void checkName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException(OVER_MESSAGE_ERROR);
        }
    }
}

