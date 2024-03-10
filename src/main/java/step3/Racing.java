package step3;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final int carNumber;
    private final int tryNumber;
    private final CarList carList;

    public static Racing createRacing(int carNumber, int tryNumber) {
        return new Racing(carNumber, tryNumber);
    }

    public Racing(int carNumber, int tryNumber) {
        this.carNumber = carNumber;
        this.tryNumber = tryNumber;
        this.carList = createCarList(carNumber);
    }

    private CarList createCarList(int carNumber) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }
        return CarList.from(cars, new RandomCreator());
    }


    public int getCarNumberOfParticipants() {
        return this.carNumber;
    }

    public int getTryNumber() {
        return this.tryNumber;
    }
}
