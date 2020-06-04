package step4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> carList;


    public Cars(String[] carNameList) {
        carList = new ArrayList<>();
        for (int i = 0; i < carNameList.length; i++) {
            this.carList.add(new Car(carNameList[i]));
        }
    }

    public Cars(String[] carNameList, int[] positionList) {

        carList = new ArrayList<>();

        for (int i = 0; i < carNameList.length; i++) {
            this.carList.add(new Car(carNameList[i], positionList[i]));
        }
    }

    public void playGame(Dice dice) {

        for (Car car : this.carList) {
            boolean greaterCheck = car.canGo(dice.makeNumber());
            car.goStopPosition(greaterCheck);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinner() {

        int maxPosition = getMaxPostion(this.carList);

        return makeWinnerList(carList, maxPosition);
    }

    private int getMaxPostion(List<Car> carList) {

        int maxPostion = 0;

        for (Car car : carList) {
            int currentPostion = car.getPosition();
            maxPostion = Integer.max(maxPostion, currentPostion);
        }

        return maxPostion;
    }

    private List<String> makeWinnerList(List<Car> carList, int maxPosition) {
        return carList.stream().filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getCarName()).collect(Collectors.toList());
    }
}
