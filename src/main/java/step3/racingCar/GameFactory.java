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

    public static Game game(){
        return new Game();
    }

    public static Cars cars(int carNum){
        List<Car> carList = new ArrayList<>();
        for(int i=0; i<carNum; i++){
            carList.add(car());
        }
        return new Cars(carList);
    }

    public static Car car(){
        return new Car();
    }
}
