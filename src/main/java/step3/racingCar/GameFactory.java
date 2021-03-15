/*
 * 자동차 경주에 필요한 인스턴스를 생성하는 팩토리 클래스
 * (팩토리 패턴 활용)
 *
 * @author hj-woo
 * @version 1.0
 * */
package step3.racingCar;

import step3.racingCar.domain.Car;
import step3.racingCar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class GameFactory {

    public static final String EMPTY_NAME = "emptyName";

    public static Game game(String[] str) {
        return new Game(str);
    }

    public static Cars namesCars(String[] names){
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(car(name));
        }
        return new Cars(carList);
    }

    public static Cars cars(int carNum) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNum; i++) {
            carList.add(car(EMPTY_NAME+i+"번째 자동차"));
        }
        return new Cars(carList);
    }
    public static Car car(){
        return new Car(EMPTY_NAME);
    }

    public static Car car(String name) {
        return new Car(name);
    }
}
