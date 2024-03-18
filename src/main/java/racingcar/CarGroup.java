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

    public void updateCarArrayPosition() {
        for (int i = 0; i < carGroup.size(); i++) {
            carGroup.get(i).updatePosition();
        }
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

    public void addWinnerNameToWinnerNames(int maxPosition, int carIndex, List<String> winners){
        if ( maxPosition == position(carIndex) ) {
            winners.add(carGroup.get(carIndex).carName());
        }
    }

    public List<String> winnerNames() {
        List<String> winners = new ArrayList<>(); // Car로 전달하면 캡슐화 깨짐
        int maxPosition = 0;
        for (int i = 0; i < carGroup.size(); i++) {
            maxPosition = Math.max(maxPosition, position(i));
        }
        for (int i = 0; i < carGroup.size(); i++) {
            addWinnerNameToWinnerNames(maxPosition, i, winners);
        }
        return winners;
    }
}
