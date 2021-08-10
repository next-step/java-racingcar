package racingcargame.model;

<<<<<<< HEAD
public class RacingCar {
    private static final int MOVING_CONDITION = 4;

    private final String name;
    private int step = 0;
=======
import java.util.Map;

public class RacingCar {
    private static final int INITIAL_LOCATION = 0;
    private static final int MAX_LENGTH_OF_NAME = 5;
    private final String name;
    private int step;
>>>>>>> origin/step2

    public RacingCar(String name) {
        checkCarNameLength(name);
        this.name = name;
<<<<<<< HEAD
    }

    public void checkCarNameLength(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (name.length() > 5) {
=======
        this.step = INITIAL_LOCATION;
    }

    public RacingCar(String name, int step) {
        checkCarNameLength(name);
        this.name = name;
        this.step = step;
    }

    private void checkCarNameLength(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }
        if (name.length() > MAX_LENGTH_OF_NAME) {
>>>>>>> origin/step2
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

<<<<<<< HEAD
    public void move(int randomNumber) {
        if (randomNumber >= MOVING_CONDITION) {
=======
    public void move(boolean isMovable) {
        if (isMovable) {
>>>>>>> origin/step2
            step += 1;
        }
    }

<<<<<<< HEAD
=======
    public void recordHistory(Map<RacingCar, Integer> history) {
        history.put(new RacingCar(this.name, this.step), step);
    }

>>>>>>> origin/step2
    public boolean isWinner(int maxScore) {
        return step == maxScore;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }
}
