package RacingCar;

import java.util.Scanner;

public class RacingCarController {
    private RacingCar[] cars;
    private int carNum;
    private int tryNum;
    private static final int MOVE_CONDITION = 4;
    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        scanInputs();
        printResultNotice();
        run();
    }

    // ==============================
    // 🔹 Input, output methods
    // ==============================
    private void scanInputs() {
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

    private void printResultNotice() {
        System.out.println("실행 결과");
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    private void initializeCars() {
        this.cars = new RacingCar[this.carNum];

        for (int i = 0; i < carNum; i++) {
            cars[i] = new RacingCar(MOVE_CONDITION);
        }
    }

    private void run() {
        initializeCars();
        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carNum; j++) {
                int randNum = cars[j].generateRandom(0, 9);
                if (cars[j].canMove(randNum)){
                    cars[j].move();
                }
                System.out.println("-".repeat(cars[j].position()));
            }
            System.out.println();
        }
    }

    public static void main(String args[]){
        RacingCarController controller = new RacingCarController();
        controller.start();
    }
}
