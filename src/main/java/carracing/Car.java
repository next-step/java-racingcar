package carracing;

import java.util.Objects;

public class Car {

    private int position;
    private final int CAN_MOVE_THRESHOLD = 4;

    public Car() {
        this.position = 1;
    }

    public void move(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 이동할 수 없습니다");
        }
        checkThreshold(number);
        this.position += number;
    }

    public String trail() {
        return makeTrail();
    }

    private String makeTrail() {
        String trail = "";
        for (int i =0; i<position; i++){
            trail+="-";
        }
        return trail;
    }

    private void checkThreshold(int number) {
        if (number > CAN_MOVE_THRESHOLD) {
            throw new RuntimeException("임계점 이하로만 이동할 수 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && CAN_MOVE_THRESHOLD == car.CAN_MOVE_THRESHOLD;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, CAN_MOVE_THRESHOLD);
    }
}
