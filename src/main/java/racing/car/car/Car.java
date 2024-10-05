package racing.car.car;

public class Car implements Movable {

    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    // 생성자에서 name을 반드시 받도록 강제
    public Car(String name) {
        this.name = name;
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

    public boolean isWin(int max) {
        return max == position;
    }

    public String getName() {
        return name;
    }

    private boolean isMoveAllowed(int number) {
        return number >= MOVE_THRESHOLD;
    }
}

