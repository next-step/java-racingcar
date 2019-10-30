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

    private Car[] cars;
    private int turn;

    public Racing(InputView inputView) {
        turn = inputView.getTurn();
        cars = new Car[inputView.getCarsName().length];
        String[] carNames = inputView.getCarsName();
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i], turn);
        }
    }

    public int getTurn() {
        return turn;
    }

    public Car[] getCars() {
        return this.cars;
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
        car.go(turn);
    }
}