/*
* 자동차 경주 게임을 진행하는 클래스
* */

package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static int carNumber;
    private static int round;
    private static List<Car> carList;
    private static Random random = new Random();

    public static void main(String[] args) {
        InputView inputView = new InputView();

        inputView.init();
        inputView.showInputCarMessage();
        carNumber = inputView.inputCarNumber();

        inputView.showInputRoundMessage();
        round = inputView.inputRound();

        makeCarList(carNumber);
        playGame(carList, round);
    }

    /**
     * 입력받은 자동차 대수로 자동차 클래스의 리스트를 만드는 메소드
     */
    public static List<Car> makeCarList(int carNumber) {
        carList = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            Car car = new Car(Constants.INITIAL_POSITION);
            carList.add(car);
        }

        return carList;
    }

    /**
     * 자동차 경주 게임을 실행하는 메소드, 각 라운드를 실행하고 자동차들의 위치를 변경한다
     */
    public static void playGame(List<Car> cars, int round) {
        ResultView resultView = new ResultView();
        resultView.showResultMessage();

        for (int i = 0; i <round; i++) {
            cars.forEach(item -> {
                playEachRound(item);
                resultView.printEachCar(item);
            });
            System.out.println();
        }
    }

    /**
     * 매 라운드마다 자동차의 전진 조건을 파악하여 자동차의 위치를 변경하는 메소드
     */
    private static void playEachRound(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    /**
     * 랜덤으로 생성된 숫자가 전진 조건인지 아닌지 판별하는 메소드
     */
    public static boolean isMovable() {
        return getRandomNumber() >= Constants.MOVE_CONDITION;
    }

    /**
     * 0에서 9사이의 랜덤값을 생성하는 메소드
     */
    private static int getRandomNumber() {
        return random.nextInt(Constants.RANDOM_RANGE);
    }
}
