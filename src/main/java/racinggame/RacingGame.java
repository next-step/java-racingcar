package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private int tryCnt;
    private List<Car> cars;

    private List<String> victoryCar;

    public RacingGame(String[] carNames, int tryCnt){
        cars = new ArrayList<>();
        for(String carName : carNames){
            cars.add(new Car(carName, 0));
        }
        this.tryCnt = tryCnt;
    }

    public boolean nextRacingGame() {
        return tryCnt > 0;
    }

    public List<Car> move() {
        tryCnt--;
        cars.stream().forEach(car -> car.carMove(car));
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxLocation() {
        return cars.stream().collect(Collectors.summarizingInt(Car::getLocation)).getMax();
    }

    public List<String> getVictorCar(){
        int maxLocation = getMaxLocation();
        return cars.stream()
                .filter(car -> car.equalsPosition(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getVictoryCar(){
        return victoryCar;
    }

}
