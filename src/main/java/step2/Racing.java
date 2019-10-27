package step2;

import java.util.Arrays;

public class Racing {
    Car[] cars;
    int turn;

    public Racing(InputView inputView) {
        turn = inputView.getTurn();
        cars = new Car[inputView.getCarNum()];
        Car car = new Car(turn);
        Arrays.fill(cars, car);
    }

}
