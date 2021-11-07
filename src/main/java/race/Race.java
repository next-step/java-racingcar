package race;

import java.util.Collection;

public class Race {
    private final Collection<Car> cars;

    private final JudgeCarMovement judgeCarMovement;

    private final RenderCarLocation renderCarLocation;

    public Race(Collection<Car> cars, JudgeCarMovement judgeCarMovement, RenderCarLocation renderCarLocation) {
        this.cars = cars;
        this.judgeCarMovement = judgeCarMovement;
        this.renderCarLocation = renderCarLocation;
    }

    public void race(int numberOfMovement) {
        for (int i = 0; i < numberOfMovement; i++) {
            moveCars();
            renderRacingSnapshot();
        }
    }

    void moveCars() {
        cars.forEach(this::moveCar);
    }

    void moveCar(Car car) {
        if(judgeCarMovement.judge().equals(JudgeCarMovement.Judge.MOVE)) {
            car.move();
        }
    }

    void renderRacingSnapshot() {
        renderCarLocation.render(cars);
    }
}
