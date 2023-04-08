package racing.carRacing;

import racing.carRacing.view.OutputView;

public class Car {
    public static final String movement = "-";
    public static final int CONDITION = 4;

    private String step;

    public Car(String step) {
        this.step = step;
    }

    public void run(MovementStrategy strategy) {
        if (strategy.movement() >= CONDITION) {
            step += movement;
        }
        OutputView.printCarStatus(step);
    }
}
