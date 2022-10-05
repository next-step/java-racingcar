package racing.ui;

import racing.domain.Car;

public interface ResultView {

    void start();

    void print(Car car);

    void enter();

    void winner(String winner);
}
