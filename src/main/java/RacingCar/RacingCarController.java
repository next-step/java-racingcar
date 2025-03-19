package RacingCar;

import NumberGenerator.*;
import java.util.Scanner;

public class RacingCarController {
    private RacingCar[] cars;
    private static final RacingCarView view = new RacingCarView();
    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();;
    private static final int MOVE_CONDITION = 4;

    public void start() {
        view.scanInputs();
        run();
        view.printResultNotice();
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    private void initializeCars(int carNum) {
        this.cars = new RacingCar[view.carNum()];

        for (int i = 0; i < carNum; i++) {
            cars[i] = new RacingCar(MOVE_CONDITION, numberGenerator);
        }
    }

    private void run() {
        initializeCars(view.carNum());
        for (int i = 0; i < view.tryNum(); i++) {
            for (int j = 0; j < view.carNum(); j++) {
                cars[j].move();
            }
            view.printResult(cars);
        }
    }

    public static void main(String args[]){
        RacingCarController controller = new RacingCarController();
        controller.start();
    }
}
