package racingGame.domain;

import racingGame.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static Cars makeCars(List<String> carNames){
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return new Cars(cars);
    }

    public void carTryMove(NumberGenerateStrategy numberGenerateStrategy){
        for(Car car : cars) {
            car.move(numberGenerateStrategy);
        }
    }

    public List<String> carWinner(){
        List<String> winner = cars.stream().filter(car -> car.isMaxPosition(getMaxPostion()))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winner;
    }

    private int getMaxPostion(){
        int maxPostion = 0;
        for (Car car : cars){
            maxPostion = car.maxPostion(maxPostion);
        }
        return maxPostion;
    }
}

