package race;

import race.outbound.RenderRaceSnapshotViaConsole;

import java.util.Collection;

public class Race {
    private final Collection<Car> cars;

    private final JudgeCarMovement judgeCarMovement;

    private final RenderRaceSnapshot renderRaceSnapshot;

    public Race(Collection<Car> cars, JudgeCarMovement judgeCarMovement, RenderRaceSnapshot renderRaceSnapshot) {
        this.cars = cars;
        this.judgeCarMovement = judgeCarMovement;
        this.renderRaceSnapshot = renderRaceSnapshot;
    }

    public void moveCars() {
        cars.forEach((car) -> {
            if(judgeCarMovement.judge()) {
                car.move();
            }
        });
    }

    public void renderRacingSnapshot() {

    }
}
