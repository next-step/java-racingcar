package racingcar;

import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCar {
    private static final int ENDNUMBER = 5;

    public static List<Car> play(String carNames, int moveCount) {
        String[] carNamesArray = inputStrSeperator(carNames);
        Cars cars =  new Cars(carNamesArray);
        for(int i=1; i<moveCount; i++){
            cars.moveCars();
            ResultView.printMovingCars(cars);
        }
        return cars.getWinners();
    }

    public List<Car> createCars(String[] cars) {
        List<Car> carList = new ArrayList<>();
        for (String carName : cars) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static String[] inputStrSeperator(String inputStr) {
        return inputStr.split(",");
    }

    private List<Car> isEndGame(List<Car> carList) {
        return carList.stream().filter(car -> car.getPosition()==ENDNUMBER).collect(Collectors.toList());
    }
}
