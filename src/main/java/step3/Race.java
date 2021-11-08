package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Race {
    private List<Car> carList;
    private Count carCount;
    private Count trialCount;
    private GameBoard gameBoard;

    public Race() {
        gameBoard = new GameBoard();
    }

    private void ready() {
        this.carCount = gameBoard.registerCar();
        this.trialCount = gameBoard.registerTrialCount();

        Car[] car = new Car[this.carCount.getCount()];

        for(int i = 0 ; i < car.length ; ++i) {
            car[i] = new Car();
        }

        this.carList = new ArrayList<>();
        this.carList.addAll(Arrays.asList(car));
    }

    private void inGame() {
        gameBoard.resultMessage();

        for(int t = 0; t < this.trialCount.getCount(); ++t) {
            for(Car c : carList) {
                int random = (int)(Math.random() * 10);
                if(random >= 4) {
                    c.move();
                    gameBoard.drawRaceProgress(c.currentPos());
                    continue;
                }
                gameBoard.drawRaceProgress(c.currentPos());
            }

            System.out.println();
        }
    }

    //진짜 메서드
    public void start() {
        ready();

        inGame();
    }
}
