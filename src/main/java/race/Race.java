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

    }

    public void moveCars() {
        cars.forEach((car) -> {
            if(judgeCarMovement.judge()) {
                car.move();
            }
        });
    }

    public void renderRacingSnapshot() {
        renderCarLocation.render(cars);
    }
}
