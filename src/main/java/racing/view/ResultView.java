package racing.view;

import java.util.List;
import racing.domain.Car;

public interface ResultView {

    void start();

    void printOfPosition(List<Car> cars);

    void winner(String winner);
}
