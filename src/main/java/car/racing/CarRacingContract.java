package car.racing;

import java.util.List;


interface ResultViewContract {

    void resultTitle();
    void newLine();
    void forward(List<Car> cars);
    void winners(String racingWinners);
}
