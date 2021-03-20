/*
 * 자동차 경주에 필요한 인스턴스를 생성하는 팩토리 클래스
 * (팩토리 패턴 활용)
 *
 * @author hj-woo
 * @version 1.0
 * */
package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameFactory {

    public static final String EMPTY_NAME = "emptyName";

    public static Game step3Game() {
        return new Game(new String[]{Game.HOW_MANY_CARS, Game.HOW_MANY_TRYS});
    }

    public static Game step4Game() {
        return new Game(new String[]{Game.INPUT_CAR_NAMES, Game.HOW_MANY_TRYS});
    }

    public static Cars namesCars(String[] names) {
        List<Car> carList = Arrays.stream(names)
                .map(GameFactory::car)
                .collect(Collectors.toList());
        return new Cars(carList);
    }

    public static Cars cars(int carNum) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            carList.add(car(EMPTY_NAME + i + "번째 자동차"));
        }
        return new Cars(carList);
    }

    public static Car car() {
        return new Car(EMPTY_NAME);
    }

    public static Car car(String name) {
        return new Car(name);
    }
}
