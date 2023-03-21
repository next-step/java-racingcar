package car.domain;

import car.view.PrintPlayMessage;

import java.util.ArrayList;
import java.util.List;

public class CarResult {

    private CarList carList;

    public CarResult(CarList carList) {
        this.carList = carList;
    }

    public void carRacingResult() {
        List<String> winnerList = new ArrayList<>();
        int maxScore = maxScoreCalculate();

        for (Car car : carList.getCars()) {
            if(car.isAtPosition(maxScore))
            {
                winnerList.add(car.getName());
            }
        }
        PrintPlayMessage.printResultMessage(winnerList);
    }

    public int maxScoreCalculate() {
        int maxValue = 0;

        for (int i = 0; i < carList.getCars().size(); i++) {
            if (maxValue < carList.getCars().get(i).getPosition()) {
                maxValue = carList.getCars().get(i).getPosition();
            }
        }
        return maxValue;
    }
}
