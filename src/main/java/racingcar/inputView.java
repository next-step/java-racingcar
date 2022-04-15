package racingcar;

import java.util.Scanner;

public class inputView {
    public static Input entry() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numOfCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfRound = scanner.nextInt();
        scanner.close();

        return new Input(numOfCar, numOfRound);
    }

    static class Input {
        int numOfCar;
        int numOfRound;

        public Input(int numOfCar, int numOfRound) {
            this.numOfCar = numOfCar;
            this.numOfRound = numOfRound;
        }
    }
}
