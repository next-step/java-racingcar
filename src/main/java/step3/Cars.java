package step3;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> carList;


    public Cars(int carCount) {
        carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            this.carList.add(new Car());
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
