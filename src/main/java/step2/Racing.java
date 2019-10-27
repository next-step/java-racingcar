package step2;

import java.util.Arrays;

public class Racing {
    Car[] cars;
    int turn;
    public static int MINIMUM_RANDOM_VALUE = 0;

    public Racing(InputView inputView) {
        turn = inputView.getTurn();
        cars = new Car[inputView.getCarNum()];
        Car car = new Car(turn);
        Arrays.fill(cars, car);
    }

    public void run() {
        for (int race = 0; race < turn; race++) {
            race(turn);
        }
    }

    public void race(int turn) {
        for (Car car : cars) {
            move(car, turn);
        }
    }

    public void move(Car car, int turn) {
        if (isPossibleToGo()) {
            car.go(turn);
        }
    }

    boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= MINIMUM_RANDOM_VALUE;
    }

}