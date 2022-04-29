package racingCar;

import java.util.List;

public class Winners {

    static public String winnersNameList(Cars cars){
        List<Car> winners = cars.winnerCars();
        String winnersNameList = "";
        for (Car winner : winners) {
            winnersNameList += winner.toString();
        }
        return winnersNameList.substring(0, winnersNameList.length()-2);
    }

}

