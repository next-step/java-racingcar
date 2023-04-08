package racing.carRacing;

public class Stages {
    private Count numberOfStages;

    public Stages(Count numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void startGame(Cars cars) {
        while (numberOfStages.isOverZero()) {
            numberOfStages.countDown();
            cars.run();
        }
    }
}
