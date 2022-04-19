package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static Input entry() {
        try {
            return scanInput();
        } catch (InputMismatchException e) {
            System.out.println("숫자 이외의 문자열은 입력할 수 없습니다. 다시 입력해주세요.");
            return scanInput();
        }
    }

    private static Input scanInput() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numOfCar = scanner.nextInt();

        System.out.println("시도할 횟수는 몇 회 인가요?");
        int numOfRound = scanner.nextInt();
        scanner.close();
        return new Input(numOfCar, numOfRound);
    }

    static class Input {
        private int numOfCar;
        private int numOfRound;

        public Input(int numOfCar, int numOfRound) {
            this.numOfCar = numOfCar;
            this.numOfRound = numOfRound;
        }

        public int getNumOfCar() {
            return numOfCar;
        }

        public int getNumOfRound() {
            return numOfRound;
        }
    }
}
