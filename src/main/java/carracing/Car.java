package carracing;

import java.util.Objects;

public class Car {

    private int position;
    private final int CAN_MOVE_THRESHOLD = 4;

    public Car() {
        this.position = 0;
    }

    public void move(int random) {
        checkBet(random);
        if (canMove(random)){
            this.position += 1;
        }
    }

    private void checkBet(int random) {
        if (random < 0 && random > 9) {
            throw new RuntimeException("0부터 9까지만 베팅가능합니다.");
        }
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

    private boolean canMove(int random) {
        if (random > CAN_MOVE_THRESHOLD) return true;
        return false;
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
