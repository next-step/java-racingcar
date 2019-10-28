/*
 * Racing.java  1.0.0   2019.10.27
 */
package step2;

/**
 * 자동차 게임 진행 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class Racing {
    private static int MINIMUM_RANDOM_VALUE = 0;
    private Car[] cars;
    private int turn;

    public Racing(InputView inputView) {
        turn = inputView.getTurn();
        cars = new Car[inputView.getCarNum()];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(turn);
        }
    }

    public int getTurn() {
        return turn;
    }

    public int getCarsLength() {
        return cars.length;
    }

    public Car getCar(int index) {
        return cars[index];
    }

    public void run() {
        for (int race = 1; race <= turn; race++) {
            race(race);
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

    private boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= MINIMUM_RANDOM_VALUE;
    }

}