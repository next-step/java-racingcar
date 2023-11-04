package carRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRacingGame {

    public static final int MAX = 10;
    private final int carCount;
    private final int raceCount;
    List<Integer> carList = new ArrayList<>();

    public CarRacingGame(int carCount, int raceCount) {
        this.carCount = carCount;
        this.raceCount = raceCount;
    }


    public void startGame() {
        init();
        for (int i = 0; i < raceCount; i++) {
            round();
            ResultView.printRoundResult(carList);
        }
    }


    public List<Integer> round() {

        for (int c = 0; c < carList.size(); c++) {
            if (isRide(random())) {
                move(c);
            }
        }

        return carList;
    }

    public void init() {
        int distance = 0;
        for (int i = 0; i < carCount; i++) {
            carList.add(distance);
        }
    }

    public void move(int c) {
        carList.set(c, carList.get(c) + 1);
    }


    public List<Integer> showCarList() {
        return carList;
    }
    

    public boolean isRide(int number) {
        if (number < 4) {
            return false;
        }
        return true;
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(MAX);
    }


}
