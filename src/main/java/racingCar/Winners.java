package racingCar;

import java.util.List;

public class Winners {

    static public List<Car> findWinners(Cars cars){
        return cars.winnerCars();
    }

    static public String winnersNameList(Cars cars){
        List<Car> winners = cars.winnerCars();
        String winnersNameList = "";
        for (Car winner : winners) {
            winnersNameList += winner.getName()+", ";
        }
        return winnersNameList.substring(0, winnersNameList.length()-2);
    }


}

