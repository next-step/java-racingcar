package step3.racingCar;

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
