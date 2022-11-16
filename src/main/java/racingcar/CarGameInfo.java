package racingcar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarGameInfo {
    private final List<Car> cars;
    private final List<StringBuilder> resultString;

    public CarGameInfo(List<Car> cars) {
        this.cars = cars;
        this.resultString = new ArrayList<>(cars.size());
        initResultString();
    }

    public void printCars(int indexOfCount) {
        for (int j=0 ; j<cars.size() ; j++) {
            Car car = cars.get(j);
            car.run(indexOfCount);
            System.out.println(car.getName() + " : " + updateDashString(car, resultString.get(j), indexOfCount));
        }
    }

    public List<Car> getWinnerList() {
        List<Car> winnerList = new LinkedList<>();
        int maxStraightCount = getMaxStraightCount();
        for(int i=0 ; i<resultString.size() ; i++) {
            decideIsWinnerCar(winnerList, i, maxStraightCount);
        }
        return winnerList;
    }

    private void initResultString() {
        for(int i=0 ; i<cars.size() ; i++) {
            resultString.add(new StringBuilder());
        }
    }

    private StringBuilder updateDashString(Car car, StringBuilder str, int indexOfCount) {
        if(car.getHistoriesByIndex(indexOfCount) == 1) {
            str.append("-");
        }
        return str;
    }

    private int getMaxStraightCount() {
        return this.cars.stream().mapToInt(Car::getTotalStraightCount).max().orElse(0);
    }


    private void decideIsWinnerCar(List<Car> winnerList, int index, int maxStraightCount) {
        if(resultString.get(index).length() >= maxStraightCount) {
            winnerList.add(cars.get(index));
        }
    }
}
