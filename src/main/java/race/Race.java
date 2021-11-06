package race;

import java.util.Collection;

public class Race {
    private final Collection<Car> cars;

    private final JudgeCarMovement judgeCarMovement;

    public Race(Collection<Car> cars, JudgeCarMovement judgeCarMovement) {
        this.cars = cars;
        this.judgeCarMovement = judgeCarMovement;
    }

    public void moveCars() {
        cars.stream().forEach((car) -> {
            if(judgeCarMovement.judge()) {
                car.move();
            }
        });
    }
}
