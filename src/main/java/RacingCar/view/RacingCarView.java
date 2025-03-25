package RacingCar.view;

import java.util.Scanner;
import java.util.StringJoiner;

public class RacingCarView {
    private String[] carNames;
    private int carNum;
    private int tryNum;
    private static Scanner scanner = new Scanner(System.in);

    // ==============================
    // 🔹 Input, output methods
    // ==============================
    public void scanInputs() {
        scanCarNames();
//        scanCarNum();
        scanTryNum();
    }

    private void scanCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesStringLine = this.scanner.next();
        this.carNames = carNamesStringLine.split(",");
        this.carNum = carNames.length;
    }

    private void scanCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carNum = this.scanner.nextInt();
    }

    private void scanTryNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryNum = this.scanner.nextInt();
    }

    public void printResultNotice() {
        System.out.println("\n실행 결과");
    }

    public void printResult(int[] positions) {
        for (int i = 0; i < this.carNum; i++) {
            System.out.println("-".repeat(positions[i]));
        }
        System.out.println();
    }

    public void printWinner(String[] names) {
        StringJoiner winnerJoiner = new StringJoiner(", ");
        for (int i = 0; i < names.length; i++) {
            winnerJoiner.add(names[i]);
        }

        System.out.println(winnerJoiner + "가 최종 우승했습니다.");
    }

    public int carNum() {
        return carNum;
    }

    public int tryNum() {
        return tryNum;
    }

    public String[] carNames() {
        return carNames;
    }
}
