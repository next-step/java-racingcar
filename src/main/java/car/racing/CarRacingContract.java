package car.racing;

import java.util.List;

interface ResultViewContract {

    void resultTitle();
    void newLine();
    void winners(List<String> winners);
    void forward(Car car);
}
