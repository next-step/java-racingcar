package carRace.step5.domain;

import carRace.step5.domain.util.CarRasingDraw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CarRacingGame {
    private static Random random = new Random();
    private HashMap<Object, List<Car>> carResultData = new HashMap<>();
    private String[] carNames;
    private static int raceTryCount;

    public CarRacingGame(String[] carNames, int raceTryCount) {
        this.carNames = carNames;
        this.raceTryCount = raceTryCount;
    }

    public void playRacingGame() {
        List<Car> list = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            car.moveCar(random.nextInt(10));
            list.add(car);

            repeatRaceTryCount(list);
            list = new ArrayList<>();
        }
    }

    public void drawRasingWinner() {
        List<Car> lastGameList = getLastPlay();
        int maxValue = getMaxWinnerSocre(lastGameList);
        List<Car> winnerList = new ArrayList<>();

        for (int i = 0; i < lastGameList.size(); i++) {
            selectWinner(maxValue, winnerList, lastGameList.get(i));
        }

        System.out.print("우승자 : " + winnerList.get(0).getCarName());
        for (int i = 1; i < winnerList.size(); i++) {
            System.out.print(", " + winnerList.get(i).getCarName());
        }
    }

    public void drawRasingGame() {
        for (int i = 0; i < raceTryCount; i++) {
            for (String carName : carNames) {
                System.out.print(carName + " : "
                 + CarRasingDraw.changeNumberToChar(carResultData.get(carName).get(i).getMoveDistance()));
                System.out.print(System.lineSeparator());
            }
            System.out.print(System.lineSeparator());
        }
    }

    private void repeatRaceTryCount(List<Car> paramList) {
        Car car;
        String carName = paramList.get(0).getCarName();

        for (int i = 1; i < raceTryCount; i++) {
            car = new Car(paramList.get(i - 1));
            car.moveCar(random.nextInt(10));
            paramList.add(car);
        }
        this.carResultData.put(carName, paramList);
    }

    private List<Car> getLastPlay() {
        List<Car> lastGameList = new ArrayList<>();

        for (String carName : carNames) {
            lastGameList.add(carResultData.get(carName).get(raceTryCount - 1));
        }

        return lastGameList;
    }

    private int getMaxWinnerSocre(List<Car> lastGameList) {
        int maxValue = 0;

        for (int i = 0; i < lastGameList.size(); i++) {
            if (maxValue <= lastGameList.get(i).getMoveDistance()) {
                maxValue = lastGameList.get(i).getMoveDistance();
            }
        }

        return maxValue;
    }

    private void selectWinner(int maxValue, List<Car> winnerList, Car car) {
        if (car.getMoveDistance() >= maxValue) {
            winnerList.add(car);
        }
    }
}
