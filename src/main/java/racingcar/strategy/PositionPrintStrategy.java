package racingcar.strategy;

import java.util.List;

public class PositionPrintStrategy implements PrintStrategy {
    @Override
    public void print(List<? extends Printable> printables) {
        for (Printable printable : printables) {
            System.out.println(printable.getPrintData());
        }
        System.out.println();
    }
}
