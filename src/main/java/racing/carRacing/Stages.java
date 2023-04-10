package racing.carRacing;

public class Stages {
    private final Count numberOfStages;

    public Stages(Count numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void startGame(Cars cars) {
        numberOfStages.countDown();
        cars.run();
    }

    public Count currentStage() {
        return numberOfStages;
    }

    public boolean isFinished() {
        return numberOfStages.isOverZero();
    }
}
