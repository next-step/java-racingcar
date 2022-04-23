package racingversion2.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingversion2.car.util.RandomValueGenerator;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(CarName[] carNames) {
        for(int i = 0; i < carNames.length; i ++){
            cars.add(new Car(carNames[i], new Position()));
        }
    }

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> executeTurn() {
        cars.stream()
            .forEach(car -> car.move(RandomValueGenerator.generateRandomValue()));
        return cars;
    }

    public List<Car> findWinners(int winningPosition){
        return cars.stream()
            .filter(car -> car.isWinner(winningPosition))
            .collect(Collectors.toList());

    }

    public int winningPosition(){
        return cars.stream()
            .mapToInt(car -> car.getPosition())
            .max()
            .getAsInt();
    }
}
