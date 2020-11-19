package racing.view;

import racing.domain.Car;
import racing.domain.Cars;
import racing.dto.RancingRecode;
import racing.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String POSITION = "-";
    public static final String CONNECT_CHAR = " : ";

    private static final String DELIMITER = ",";
    private static final String VICTORY_MSG = "가 최종우승 했습니다.";

    private ResultView() {
    }

    public static void printVictoryCarNames(Cars cars) {
        System.out.println(getVictoryCarNames(cars) + VICTORY_MSG);
    }

    public static void printRacingRecdoe(List<RancingRecode> listRecode) {
        listRecode.forEach(recode -> System.out.println(recode.getName() + CONNECT_CHAR + StringUtils.repeat(POSITION, recode.getPosition())));
    }

    private static String getVictoryCarNames(Cars cars) {
        return cars.getCarList().stream()
                .filter(car -> car.isGreaterOrEqualsPosition(cars.getHighPosition()))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
