package racing.domain.car;

import racing.domain.game.Calculator;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> items;

    public Cars(List<Car> items) {
        this.items = items;
    }

    //깊은 복사 RacingGame 뷰 분리를 위해서
    public Cars(Cars cars){
        List<Car> newCars = new ArrayList<>();
        for(Car car : cars.items){
            newCars.add(new Car(car));
        }
        this.items = newCars;
    }

    public Cars carGoAndStop(Calculator calculator) {
        for (Car item : items) {
            item.isGo(calculator.getRandomNumber());
        }
        return this;
    }

    public List<Car> getItems() {
        return items;
    }
}
