package racingcar;

import racingcar.ui.ResultView;
import java.util.List;

import static racingcar.utils.StringUtils.inputStringSeperator;

public class RacingCar {
    public static List<Car> play(String carNames, int moveCount) {
        String[] carNamesArray = inputStringSeperator(carNames);
        Cars cars =  new Cars(carNamesArray);
        for(int i=0; i<moveCount; i++){
            cars.moveCars();
            ResultView.printMovingCars(cars);
        }
        return cars.getWinners();
    }
}
