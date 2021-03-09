package racing_game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for(int i = 0; i < carNames.length; i++){
            this.cars.add(new Car(carNames[i]));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> winner(){
        return cars.stream().
            filter(car -> car.isWinner(maxMoveCount()))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public int maxMoveCount(){
        return cars
            .stream()
            .mapToInt(Car::getMoveCount)
            .max()
            .orElse(0);
    }
}
