package racingGame.domain;

import racingGame.strategy.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private static final String CARS_NULL_ERROR_MESSAGE = "자동차를 생성해주세요";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        carsNullChk(cars);
        this.cars = cars;
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
        List<String> winner = cars.stream().filter(car -> car.isSamePosition(getMaxPostion()))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winner;
    }

    private int getMaxPostion(){
       return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<Car> getCars(){
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
