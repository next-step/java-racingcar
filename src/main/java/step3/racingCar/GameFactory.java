/*
 * 자동차 경주에 필요한 인스턴스를 생성하는 팩토리 클래스
 * (팩토리 메소드 패턴 활용)
 *
 * @author hj-woo
 * @version 1.0
 * */
package step3.racingCar;

import step3.racingCar.domain.Car;
import step3.racingCar.domain.Cars;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameFactory {

    public static Game game(){
        return new Game();
    }

    public static Cars cars(int carNum){
        Cars cars = new Cars();

        List<Car> carList = new LinkedList<>();
        for(int i=0; i<carNum; i++){
            carList.add(car());
        }
        cars.setCars(carList);
        return cars;
    }

    public static Car car(){
        Car car = new Car();
        Random random = new Random();
        car.setRandom(random);
        return car;
    }
}
