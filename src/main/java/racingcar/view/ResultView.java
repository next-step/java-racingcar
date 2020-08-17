package racingcar.view;

import racingcar.domain.Car;
import racingcar.strategy.DoOneForward;
import racingcar.strategy.OneForwardCondition;
import racingcar.strategy.RaceCondition;
import racingcar.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Constants.*;
import static racingcar.utils.StringUtils.repeat;

public class ResultView{
    public static void printCars(List<Car> cars) {
        System.out.println(SAY_VIEW_RESULT);
        cars.forEach(ResultView::dashPosition);
    }

    public static void dashPosition(Car car) {
        repeat("-", car.getPosition());
    }

}
