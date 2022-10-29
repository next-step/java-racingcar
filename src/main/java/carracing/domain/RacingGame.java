package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> winnerList = new ArrayList<>();
    private int tryCount;

    public RacingGame(List<String> nameList, int tryCount) {
        this.tryCount = tryCount;
        for (int i = 0; i < nameList.size(); i++) {
            this.carList.add(new Car(i+1,nameList.get(i)));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public boolean remainTryCount() {
        return this.tryCount >0;
    }

    public void racing() {
        final NumberGenerator numberGenerator = new RandomNumberGenerator();
        carList.forEach(car->car.move(numberGenerator));
        reduceTryCount();
    }

    public void reduceTryCount() {
        tryCount--;
    }

    public List<String> getWinners(){

        return winnerList;
    }
}
