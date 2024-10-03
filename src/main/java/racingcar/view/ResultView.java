package racingcar.view;

import racingcar.model.Car;
import racingcar.service.CarRacing;

import java.util.List;

public class ResultView {
    private CarRacing carRacing;

    public ResultView() {}

    public ResultView(CarRacing carRacing) {
        this.carRacing = carRacing;
        System.out.println("실행 결과");
    }

    public void printCarsStatusResult() {
        List<Car> carsStatus = carRacing.getCarsStatus();

        for(int i = 0; i < carsStatus.size(); i++) {
            int carMovingDistance = carsStatus.get(i).getCarMovingDistance();
            StringBuilder dashCharacterString = changeMovingDistanceToDashCharacter(carMovingDistance);
            System.out.println(dashCharacterString.toString());
        }

        System.out.println();
    }

    private StringBuilder changeMovingDistanceToDashCharacter(int carMovingDistance) {
        StringBuilder dashCharacterString = new StringBuilder();

        for(int i = 0; i < carMovingDistance; i++) {
            dashCharacterString.append("-");
        }

        return dashCharacterString;
    }
}
