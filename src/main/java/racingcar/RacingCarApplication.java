package racingcar;

import racingcar.car.Car;
import racingcar.car.RandomMovingStrategy;

import java.util.List;
import java.util.Scanner;

/**
 * 초간단 자동차 경주 게임을 구현한다.
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
 */
public class RacingCarApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요 ?");
        int numberOfCar = scanner.nextInt();

        System.out.println("시도할 회수는 몇 회 인가요 ?");
        int numberOfTime = scanner.nextInt();

        System.out.println("실행 결과");

        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(numberOfCar, new RandomMovingStrategy());
        List<Car> result;

        for(int i = 0; i < numberOfTime; i++) {
            result = racingGame.execute();
            resultView.print(result);
        }
    }
}
