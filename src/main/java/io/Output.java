package io;

import domain.Car;
import java.util.List;

// todo input 처럼 출력대상만을 신경써야함
public interface Output {
    void setCarCount();
    void setCarNames();
    void setGameCount();
    void startMessage();
    void carMileage(List<Car> cars);
}
