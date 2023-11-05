package step3.presentation;

import java.util.Scanner;

public class InputView {

        private final int carCnt;
        private final int round;

        public InputView(int carCnt, int round) {
                this.carCnt = carCnt;
                this.round = round;
        }

        public static InputView scanAndGetValues() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("자동차 대수는 몇 대 인가요?");
                int carCntInput = scanner.nextInt();
                System.out.println("시도할 회수는 몇 회 인가요?");
                int tryCntInput = scanner.nextInt();
                return new InputView(carCntInput, tryCntInput);
        }

        public int getCarCnt() {
                return carCnt;
        }

        public int getRound() {
                return round;
        }
}
