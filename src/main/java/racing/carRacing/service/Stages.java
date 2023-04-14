package racing.carRacing.service;

import racing.carRacing.model.Cars;
import racing.carRacing.model.Count;

public class Stages {
    private final Count numberOfStages;

    public Stages(Count numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void startGame(Cars cars, MovementStrategy movementStrategy) {
        numberOfStages.countDown();
        cars.run(movementStrategy);
    }

    public Count currentStage() {
        return numberOfStages;
    }

    public boolean hasMoreStages() {
        return numberOfStages.isOverZero();
    }
}
