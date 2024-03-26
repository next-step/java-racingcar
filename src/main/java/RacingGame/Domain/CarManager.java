package RacingGame.Domain;

import java.util.*;

public class CarManager {
    List<Car> carList;
    int[][] carHistory;
    int trialCount;

    public CarManager(int trialNum, String[] carNames, RandomNumberStrategy randomNumberStrategy) {
        carList = new ArrayList<>();
        carHistory = new int[carNames.length][trialNum];
        trialCount = trialNum;
        for (String carName : carNames) {
            Car car = new Car(carName);
            car.setStrategy(randomNumberStrategy);
            carList.add(car);
        }
    }

    public void moveForwardCars() {
        for (int i = 0; i < trialCount; i++) {
            moveForward(i);
        }
    }

    private void moveForward(int curTry) {
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).moveForward();
            carHistory[j][curTry] = carList.get(j).getMoveInfo();
        }
    }

    public int[][] getCarHistory() {
        return carHistory;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinners() {
        Integer[] moveList = new Integer[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            moveList[i] = carList.get(i).getMoveInfo();
        }
        Arrays.sort(moveList, Collections.reverseOrder());
        int maxMove = moveList[0];
        return findWinner(maxMove);
    }

    private List<String> findWinner(int maxMove) {
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getMoveInfo() == maxMove) winnerList.add(car.getName());
        }
        return winnerList;
    }
}
