package racing.carRacing;

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

    public boolean isFinished() {
        return numberOfStages.isOverZero();
    }
}
