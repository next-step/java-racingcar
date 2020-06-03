package step4;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;


    public Cars(String[] carNameList) {
        carList = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            this.carList.add(new Car(carNameList[i]));
        }
    }

    public void playGame(Dice dice) {
        for (Car car : this.carList) {
            boolean greaterCheck = car.canGo(dice.makeNumber());
            car.goStopPosition(greaterCheck);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }
}
