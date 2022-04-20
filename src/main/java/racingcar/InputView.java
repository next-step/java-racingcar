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
        String[] carNames = scanCarNames();
        int numOfRound = scanNumOfRound();
        
        return new Input(carNames, carNames.length, numOfRound);
    }

    private static String[] scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();
        scanner.close();

        return carNames.split(",");
    }

    private static int scanNumOfRound() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numOfRound = scanner.nextInt();
        scanner.close();

        return numOfRound;
    }

    static class Input {
        private String[] carNames;
        private int numOfCar;
        private int numOfRound;

        public Input(String[] carNames, int numOfCar, int numOfRound) {
            this.carNames = carNames;
            this.numOfCar = numOfCar;
            this.numOfRound = numOfRound;
        }

        public int getNumOfCar() {
            return numOfCar;
        }

        public int getNumOfRound() {
            return numOfRound;
        }

        public String[] getCarNames() {
            return carNames;
        }
    }
}
