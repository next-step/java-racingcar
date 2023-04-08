package racing.carRacing;

public class Stages {
    private Count numberOfStages;

    public Stages(Count numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void startGame(Cars cars) {
        System.out.println("실행 결과");
        while (numberOfStages.isOverZero()) {
            numberOfStages.countDown();
            cars.run();
            System.out.println();
        }
    }
}
