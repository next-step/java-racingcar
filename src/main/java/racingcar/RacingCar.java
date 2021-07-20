package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingCar {
    private static final int ENDNUMBER = 5;

    public List<Car> play(String inputStr, int excuteNumber) {
        Cars cars =  new Cars(createCars(seperator(inputStr)));
        System.out.println();
        for(int i=1; i<excuteNumber; i++){
            cars.moveCars();
            System.out.println();
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

    public String[] seperator(String inputStr) {
        return inputStr.split(",");
    }

    private List<Car> isEndGame(List<Car> carList) {
        return carList.stream().filter(car -> car.getPosition()==ENDNUMBER).collect(Collectors.toList());
    }

}
