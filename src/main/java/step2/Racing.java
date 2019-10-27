/*
 * Racing.java  1.0.0   2019.10.27
 */
package step2;

/**
 * 자동차 게임 진행 부분
 * @version 1.0.0
 * @author naheenosaur
 */
public class Racing {
    Car[] cars;
    int turn;
    public static int MINIMUM_RANDOM_VALUE = 4;

    public Racing(InputView inputView) {
        turn = inputView.getTurn();
        int carNum = inputView.getCarNum();
        cars = new Car[carNum];
        for (int num = 0; num < carNum; num++) {
            cars[num] = new Car(turn);
        }
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