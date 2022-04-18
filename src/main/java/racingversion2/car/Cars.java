package racingversion2.car;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(CarName[] carNames) {
        for(int i = 0; i < carNames.length; i ++){
            cars.add(new Car(carNames[i], new Position()));
        }
    }

    public List<Car> executeTurn() {
        cars.stream().forEach(car -> car.move());
        return cars;
    }

    public List<Car> findWinners(){
        List<Car> winners = new ArrayList<>();
        cars.stream()
            .filter(car -> car.getPosition() == winningPosition())
            .forEach(car -> winners.add(car));
        return winners;
    }

    private int winningPosition(){
        return cars.stream().mapToInt(car -> car.getPosition()).max().getAsInt();
    }
}
