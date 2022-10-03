package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final List<RacingCar> cars;
    private final List<StringBuilder> resultString;

    public ResultView(List<RacingCar> cars) {
        this.cars = cars;
        this.resultString = new ArrayList<>(cars.size());
        initResultString();
    }

    public void printCars() {
        int count = cars.get(0).getHistoryCount();
        for (int i=0 ; i<count ; i++) {
            for (int j=0 ; j<cars.size() ; j++) {
                RacingCar car = cars.get(j);
                printDash(car, resultString.get(j), i);
            }
            System.out.println();
        }
    }

    private void initResultString() {
        for(int i=0 ; i<cars.size() ; i++) {
            resultString.add(new StringBuilder());
        }
    }

    private void printDash(RacingCar car, StringBuilder str, int indexOfCount) {
        if(car.getHistoriesByIndex(indexOfCount) == 1) {
            str.append("-");
        }
        System.out.println(str);
    }


}
