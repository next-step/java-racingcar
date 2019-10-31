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
    private MoveStrategy moveStrategy;

    public Racing(InputView inputView) {
        this(inputView, new DefaultMove());
    }

    public Racing(InputView inputView, MoveStrategy moveStrategy) {
        turn = inputView.getTurn();
        String[] carNames = inputView.getCarsName();
        int length = carNames.length;
        cars = new Car[length];
        for (int i = 0; i < length; i++) {
            cars[i] = new Car(carNames[i], turn);
        }
        this.moveStrategy = moveStrategy;
    }

    public int getTurn() {
        return turn;
    }

    public Car[] getCars() {
        return this.cars;
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
        if (moveStrategy.isPossibleToGo()) {
            car.go(turn);
        }
    }
}