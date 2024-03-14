package race;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList = new ArrayList<>();
    private static ExtractRandom extractRandom = new ExtractRandom();
    private static final int STANDARD = 4;

    public List<Car> createCar(int number) {
        for (int i=0; i<number; i++) {
            carList.add(new Car(0));
        }
        return carList;
    }

    public boolean canForward(int number) {
        return number >= STANDARD;
    }

    public void decideForward(int size) {
        for (int i=0; i<carList.size(); i++) {
            addForward(carList.get(i));
        }
    }

    public void addForward(Car car) {
        if (canForward(extractRandom.getRandomNumber())) {
            car.location += 1;
        }
    }
}
