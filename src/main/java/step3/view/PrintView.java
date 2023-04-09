package step3.view;

import step3.domain.Repetitions;
import step3.strategy.draw.DrawStrategy;

import java.util.List;

public class PrintView {
    private final DrawStrategy drawStrategy;

    private PrintView(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public static PrintView of(DrawStrategy drawStrategy) {
        return new PrintView(drawStrategy);
    }

    private void print(Repetitions repetitions) {
        System.out.println(repetitions.getRepetitions() + "번째 reps");
        repetitions.getCarList().forEach(racingCar -> System.out.println(drawStrategy.draw(racingCar.getCurrentLocation())));
        System.out.println("========================================");
    }

    public void printAll(List<Repetitions> repetitionsList) {
        repetitionsList.forEach(this::print);
    }
}
