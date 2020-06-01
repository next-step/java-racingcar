package step4;

import step3.Dice;

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
            if (greaterCheck) {
                car.goPosition();
            }
        }
    }

    public List<Integer> getPositionList() {

        List<Integer> positionList = new ArrayList();

        for (Car car : this.carList) {
            positionList.add(car.getPosition());
        }

        return positionList;
    }
}
