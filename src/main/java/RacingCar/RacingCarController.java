package RacingCar;

import NumberGenerator.*;
import java.util.Scanner;

public class RacingCarController {
    private RacingCar[] cars;
    private static final RacingCarView view = new RacingCarView();
    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();
    private int maxCarPosition = 0;
    private static final int MOVE_CONDITION = 4;

    public void start() {
        view.scanInputs();
        view.printResultNotice();
        run();
        RacingWinnerFinder winnerFinder = new RacingWinnerFinder(this.cars);
        winnerFinder.findWinners(this.maxCarPosition);
        view.printWinner(winnerFinder.winners());
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    private void initializeCars(int carNum) {
        this.cars = new RacingCar[view.carNum()];
        String[] carNames = view.carNames();
        for (int i = 0; i < carNum; i++) {
            cars[i] = new RacingCar(MOVE_CONDITION, numberGenerator, carNames[i]);
        }
    }

    private void run() {
        initializeCars(view.carNum());
        for (int i = 0; i < view.tryNum(); i++) {
            for (int j = 0; j < view.carNum(); j++) {
                cars[j].move();
                if (cars[j].position() > this.maxCarPosition){
                    this.maxCarPosition = cars[j].position();
                }
            }
            view.printResult(cars);
        }
    }

    public static void main(String args[]) {
        RacingCarController controller = new RacingCarController();
        controller.start();
    }
}
