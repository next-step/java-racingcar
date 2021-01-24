package racingcar;


import racingcar.view.RacingGamePrinter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {

    private final int LOWER_BOUND_MOVE = 4;

    private final ArrayList<RacingCar> cars;
    private final List<String> winners;
    private final Scanner sc = new Scanner(System.in);
    private int numberOfRound;
    private final Random rand;

    public RacingGameController(String carsName, int numberOfRound) {

        this.cars = new ArrayList<>();
        setCarsName(carsName);
        this.winners = new ArrayList<>();
        this.rand = new Random();
        this.numberOfRound = numberOfRound;
    }

    public ArrayList<RacingCar> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return winners;
    }


    public void setCarsName(String input) {

        String[] inputs = input.split(",");
        for (String s : inputs) {
            cars.add(new RacingCar(s));
        }
    }

    public boolean isEnd() {

        if (numberOfRound > 0) {
            numberOfRound--;
            return false;
        }
        return true;
    }


    public void playRound() {

        for (RacingCar car : cars) {
            moveEachCar(car);
        }
    }

    public void moveEachCar(RacingCar racingCar) {

        if (getRandomNumber() >= LOWER_BOUND_MOVE) {
            racingCar.movingForward();
        }
    }

    private int getRandomNumber() {

        return rand.nextInt(10);
    }




    public void findWinnerWithMaxStatus(int maxStatus) {

        for (int i = 0; i < cars.size(); i++) {
            findEachWinner(i, maxStatus);
        }
    }

    public int getMaxStatusAmongPlayers() {

        int maxStatus = 0;
        for (RacingCar car : cars) {
            maxStatus = Math.max(maxStatus, car.getStatus());
        }
        return maxStatus;
    }

    private void findEachWinner(int index, int maxStatus) {

        if (cars.get(index).getStatus() == maxStatus) {
            winners.add(cars.get(index).getName());
        }
    }

}
