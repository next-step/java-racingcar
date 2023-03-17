package car.domain;

import car.view.CarPlayMessage;

import java.util.ArrayList;
import java.util.List;

public class CarResult {

    private CarList carList;

    public CarResult(CarList carList) {
        this.carList = carList;
        carRacingResult();
    }

    public void carRacingResult() {
        List<String> winnerList = new ArrayList<>();
        int maxScore = maxScoreCalculate();

        for (Car car : carList.getCarNameList()) {
            if (maxScore == car.getPosition()) {
                winnerList.add(car.getName());
            }
        }
        CarPlayMessage.playResultMessage(winnerList);
    }

    public int maxScoreCalculate() {
        int maxValue = 0;

        for (int i = 0; i < carList.getCarNameList().size(); i++) {
            if (maxValue < carList.getCarNameList().get(i).getPosition()) {
                maxValue = carList.getCarNameList().get(i).getPosition();
            }
        }
        return maxValue;
    }
}
