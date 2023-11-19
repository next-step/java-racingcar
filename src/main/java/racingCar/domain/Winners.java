package racingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    public static List<String> findWinner(List<Car> carList){
        List<String> winners = returnWinnerCars(carList);

        return winners;
    }

    public static List<String> returnWinnerCars(List<Car> carList){
        List<String> winners = new ArrayList<>();
        int maxForward = getMaxForward(carList);

        for(Car car : carList){
            car.addMaxForwardCar(maxForward, winners);
        }

        return winners;
    }

    public static int getMaxForward(List<Car> carList){
        int maxForward = 0;
        for(Car car : carList){
            maxForward = car.returnMaxCount(maxForward);
        }

        return maxForward;
    }
}
