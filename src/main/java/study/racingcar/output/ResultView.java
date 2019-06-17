package study.racingcar.output;

import study.racingcar.model.Car;

import java.util.List;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public interface ResultView {
    void printInit();
    void print(List<Car> cars);
}
