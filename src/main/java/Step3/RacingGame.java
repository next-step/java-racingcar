package Step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private final List<RacingCar> cars;
    private int playNum;
    private boolean hasBoard;

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.playNum = 0;
        this.hasBoard = false;
    }

    public void makeBoard(int carNum, int playNum) {
        this.playNum = playNum;

        this.cars.clear();

        for (int i = 0; i < carNum; i++) {
            this.cars.add(new RacingCar());
        }

        this.hasBoard = true;
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public boolean play() {
        if (!this.hasBoard) {
            return false;
        }

        System.out.println("실행 결과");

        Random random = new Random();
        for (int i = 0; i < this.playNum; i++) {
            moveCar(random);
            System.out.println();
        }

        return true;
    }

    private void moveCar(Random random) {
        for (RacingCar car : this.cars) {
            car.move(random.nextInt(10));
            car.print();
            System.out.println();
        }
    }
}
