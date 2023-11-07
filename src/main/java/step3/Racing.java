package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    List<Car> cars = new ArrayList<>();
    int round;
    Random random;

    public void gameSetup(int numCar, int round, Random random) {
        this.round = round;
        this.random = random;
        for (int i = 0; i < numCar ; i++) {
            Car car = new Car();
            cars.add(car);
        }
    }

    public void startGame() {
        for (int i = 0; i < round; i++) {
            moveCar(random);
            System.out.println("******** "+(i+1)+" 라운드 ********"); // 라운드별 구분자
            ResultView.display(cars);
        }
    }

    private void moveCar(Random random) {
        for (int i = 0; i < cars.size(); i++) {
            moveIfNumberIsGreaterThanFour(random, i);
        }
    }

    private void moveIfNumberIsGreaterThanFour(Random random, int j) {
        if (random.nextInt(10) >= 4) {
            cars.get(j).index++;
        }
    }
}