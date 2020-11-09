package car.racing.view;

import car.racing.domain.Car;

import java.util.List;

public interface ResultViewContract {

    void resultTitle();
    void newLine();
    void winners(List<String> winners);
    void forward(Car car);
}
