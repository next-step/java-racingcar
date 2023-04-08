package racing.carRacing;

import racing.carRacing.view.OutputView;

public class Stages {
    private final Count numberOfStages;

    public Stages(Count numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void startGame(Cars cars) {
        OutputView.printTotalStage(numberOfStages);
        while (numberOfStages.isOverZero()) {
            OutputView.printRemainStage(numberOfStages);
            numberOfStages.countDown();
            cars.run();
        }
    }
}
