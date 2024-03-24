package RacingGame.Domain;

import java.util.*;

public class CarManager {
    List<Car> carList;
    int[][] carHistory;

    public CarManager(int trialNum, String[] carNames) {
        carList = new ArrayList<>();
        carHistory = new int[carNames.length][trialNum];
        for (int i = 0; i < carNames.length; i++) {
            Car car = new Car(carNames[i]);
            carList.add(car);
        }
    }

    public void MoveForwardCars(int trialNum) {
        for (int i = 0; i < trialNum; i++) {
            moveForward(i);
        }
    }

    private void moveForward(int trialNum) {
        for (int j = 0; j < carList.size(); j++) {
            carList.get(j).MoveForward();
            carHistory[j][trialNum] = carList.get(j).GetMoveInfo();
        }
    }

    public int[][] GetCarHistory() {
        return carHistory;
    }

    public List<Car> GetCarList() {
        return carList;
    }

    public List<String> GetWinners() {
        Integer[] moveList = new Integer[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            moveList[i] = carList.get(i).GetMoveInfo();
        }
        Arrays.sort(moveList, Collections.reverseOrder());
        int maxMove = moveList[0];
        List<String> winnerList = findWinner(maxMove);
        return winnerList;
    }

    private List<String> findWinner(int maxMove) {
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).GetMoveInfo() == maxMove) winnerList.add(carList.get(i).GetName());
        }
        return winnerList;
    }


    public void SetStrategy(RandomNumberStrategy randomNumberStrategy) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).SetStrategy(randomNumberStrategy);
        }
    }
}
