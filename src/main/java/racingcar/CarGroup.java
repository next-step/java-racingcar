package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGroup {

    private List<Car> carGroup;

    public CarGroup(String[] carNames) {
        carGroup = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carGroup.add(new Car(carNames[i]));
        }
    }

    public Car Car(int carIndex) {
        return carGroup.get(carIndex);
    }

    public int carGroupSize() {
        return carGroup.size();
    }

    public int position(int carIndex) {
        return carGroup.get(carIndex).position();
    }

    public String carName(int carIndex) {
        return carGroup.get(carIndex).carName();
    }

    public void updateCarArrayPosition() {
        for (int i = 0; i < carGroup.size(); i++) {
            carGroup.get(i).updatePosition();
        }
    }

    // indent 요구사항을 위해 함수를 무리하게 쪼갰는데 좋은 코드는 아닌 거 같음
    public void addWinnerNameToWinners(int maxPosition, int carIndex, List<Car> winners){
        if ( maxPosition == position(carIndex) ) {
            winners.add(carGroup.get(carIndex));
        }
    }

    public List<Car> winners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = 0;
        for (int i = 0; i < carGroup.size(); i++) {
            maxPosition = Math.max(maxPosition, position(i));
        }
        for (int i = 0; i < carGroup.size(); i++) {
            addWinnerNameToWinners(maxPosition, i, winners);
        }
        return winners;
    }
}
