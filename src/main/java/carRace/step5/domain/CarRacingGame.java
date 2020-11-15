package carRace.step5.domain;

import carRace.step5.view.CarRasingDraw;

import java.util.*;

public class CarRacingGame {
    private static Random random = new Random();

    private List<Car> carsScore = new ArrayList<>();
    private static int raceTryCount;
    private String[] carNames;

    public CarRacingGame(int raceTryCount, String[] carNames) {
        this.raceTryCount = raceTryCount;
        this.carNames = carNames;
    }

    public void RunPlayGame() {
        makeCars(carNames);
        playRasingGame();
        drawRasingWinner();
    }

    private void playRasingGame() {
        for (int i = 0; i < raceTryCount; i++) {
            repeatRaceTryCount();
            System.out.print(System.lineSeparator());
        }
    }

    private void repeatRaceTryCount() {
        for (Car car : carsScore) {
            car.moveCar(random.nextInt(10));
            CarRasingDraw.printCarDistance(car.getCarName(), car.getMoveDistance());
        }
    }

    private void drawRasingWinner() {
        int maxScore = getMaxWinnerSocre();
        List<String> winnerList = new ArrayList<>();

        for (int i = 0; i < carsScore.size(); i++) {
            selectWinner(maxScore, winnerList, i);
        }

        CarRasingDraw.printWinner(winnerList);
    }

    private void selectWinner(int maxValue, List<String> winnerList, int index) {
        if (carsScore.get(index).getMoveDistance() >= maxValue) {
            winnerList.add(carsScore.get(index).getCarName());
        }
    }

    private int getMaxWinnerSocre() {
        int maxValue = 0;

        for (int i = 0; i < carsScore.size(); i++) {
            if (maxValue <= carsScore.get(i).getMoveDistance()) {
                maxValue = carsScore.get(i).getMoveDistance();
            }
        }

        return maxValue;
    }

    /**
     * 레이싱 게임을 참여할 자동차 생성
     *
     * @param carNames
     * @return
     */
    private void makeCars(String[] carNames) {

        for (String carName : carNames) {
            Car car = new Car(carName);
            carsScore.add(car);
        }
    }

    public String[] getCarNames() {
        return carNames;
    }

    public static int getRaceTryCount() {
        return raceTryCount;
    }
}
