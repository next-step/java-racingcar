package carracing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int RANDOM_RANGE = 10;

    private static final List<Car> carList = new ArrayList<>();
    private static int tryCount;

    private static final Random random = new Random();

    public RacingGame(int carCount, int tryCount) {
        this.tryCount = tryCount;

        for (int i = 0; i < carCount; i++) {
            this.carList.add(new Car(i + 1));
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public boolean remainTryCount() {
        return this.tryCount >0;
    }

    public void setMovable(){
        for(Car car:carList){
            car.setMovable(random.nextInt(RANDOM_RANGE));
        }
    }

    public void racing() {
        carList.forEach(car->car.move());
        reduceTryCount();
    }

    public void reduceTryCount() {
        tryCount--;
    }
}
