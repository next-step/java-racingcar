package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;


    public Cars(int carCount){
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.carList.add(new Car());
        }
    }

    public List<Car> playGame(Dice dice) {
        for (Car car:this.carList) {
            boolean greaterCheck = car.canGo(dice.makeRandomNumber());
            if (greaterCheck) {
                car.goPosition();
            }
        }
        return this.carList;
    }
}
