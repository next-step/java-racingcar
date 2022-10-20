package racingGame.domain;

import racingGame.strategy.MoveStrategy;
import racingGame.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String CARS_NULL_ERROR_MESSAGE = "자동차를 생성해주세요";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        carsNullChk(cars);
        this.cars = cars;
    }

    public List<Car> getCars(){
        return this.cars;
    }

    private void carsNullChk(List<Car> cars){
        if(cars.isEmpty()){
            throw new NullPointerException(CARS_NULL_ERROR_MESSAGE);
        }
    }

    public static Cars makeCars(int CarCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < CarCount; i++){
            cars.add(new Car());
        }
        return new Cars(cars);
    }

    public void carTryMove(MoveStrategy moveStrategy,NumberGenerateStrategy numberGenerateStrategy){
        for(Car car : cars) {
            car.move(moveStrategy, numberGenerateStrategy);
        }
    }




}
