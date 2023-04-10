package racingcar.strategy;

import java.util.List;

public interface PrintStrategy {
    void print(List<? extends Printable> printables);
}
