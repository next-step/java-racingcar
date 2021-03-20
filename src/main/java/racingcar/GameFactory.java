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

    public static final String EMPTY_NAME = "e";
    public static final String HOW_MANY_CARS = "자동차 대수는 몇 대 인가요?";
    public static final String HOW_MANY_TRYS = "시도할 회수는 몇 회 인가요?";
    public static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public static final String[] STEP3_STR = {HOW_MANY_CARS, HOW_MANY_TRYS};
    public static final String[] STEP4_STR = {INPUT_CAR_NAMES, HOW_MANY_TRYS};

    public static Game step3Game(List<Object> inputArr) {
        return new Game(STEP3_STR, inputArr);
    }

    public static Game step4Game(List<Object> inputArr) {
        return new Game(STEP4_STR, inputArr);
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
            carList.add(car(EMPTY_NAME + i));
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
