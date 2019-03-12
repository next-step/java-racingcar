package domain;

import java.util.List;

public interface Output {
    void setCarCount();
    void setGameCount();
    void startMessage();
    void carMileage(List<Car> cars);
}
