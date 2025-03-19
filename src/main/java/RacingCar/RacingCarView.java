package RacingCar;

import java.util.Scanner;

public class RacingCarView {
    private int carNum;
    private int tryNum;
    private static Scanner scanner = new Scanner(System.in);

    // ==============================
    // 🔹 Input, output methods
    // ==============================
    void scanInputs() {
        scanCarNum();
        scanTryNum();
    }

    private void scanCarNum() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        this.carNum = this.scanner.nextInt();
    }

    private void scanTryNum() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        this.tryNum = this.scanner.nextInt();
    }

    void printResultNotice() {
        System.out.println("실행 결과");
    }

    void printResult(RacingCar[] cars){
        for (int i=0; i<this.carNum; i++){
            System.out.println("-".repeat(cars[i].position()));
        }
        System.out.println();
    }

    int carNum(){
        return carNum;
    }

    int tryNum(){
        return tryNum;
    }
}
