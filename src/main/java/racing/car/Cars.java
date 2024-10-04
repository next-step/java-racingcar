package racing.car;

import racing.game.Calculator;

import java.util.List;

public class Cars {

    private final List<Car> items;

    public Cars(List<Car> items) {
        this.items = items;
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
