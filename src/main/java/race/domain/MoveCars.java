package race.domain;

import java.util.Collection;

public class MoveCars {
    private final JudgeCarMovement judgeCarMovement;

    public MoveCars(JudgeCarMovement judgeCarMovement) {
        this.judgeCarMovement = judgeCarMovement;
    }

    public void moveCars(Collection<Car> cars) {
        cars.forEach(this::moveCar);
    }

    void moveCar(Car car) {
        if (judgeCarMovement.judge().equals(JudgeCarMovement.Judge.MOVE)) {
            car.move();
        }
    }
}
