package step3;

import java.util.List;
import java.util.Scanner;

public class SimpleCarRacing {

    public static void main(String[] args) {
        RacingCondition racingCondition = RacingCondition.getInput();

    }

    public static class Game {
        private RacingCondition racingCondition;
        private List<Car> cars;

        public void start() {

        }
    }

    public static class GameRule {
        public static boolean isGoStraight(int number) {
            return number >= 4;
        }
    }

    public static class Car {
        private Integer carNumber;
        private Integer straightCount;

        public Car(Integer carNumber) {
            this.carNumber = carNumber;
            this.straightCount = 0;
        }

        public void tryMove(int givenCondition) {
            if (GameRule.isGoStraight(givenCondition)) {
                move();
            }
        }

        private void move() {
            this.straightCount += 1;
        }

        public Integer getStraightCount() {
            return straightCount;
        }
    }

    public static class RacingCondition {
        private Integer carCount;
        private Integer attemptCount;

        public RacingCondition(Integer carCount, Integer attemptCount) {
            this.carCount = carCount;
            this.attemptCount = attemptCount;
        }

        public static RacingCondition getInput() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("자동차 대수는 몇 대 인가요?");
            int carCount = scanner.nextInt();
            System.out.println("시도할 회수는 몇 회 인가요?");
            int attemptCount = scanner.nextInt();

            return new RacingCondition(carCount, attemptCount);
        }
    }
}
