package RacingCar.controller;

import NumberGenerator.*;
import RacingCar.model.*;
import RacingCar.view.RacingCarView;

public class RacingCarController {
    private RacingCar[] cars;
    private static final RacingCarView view = new RacingCarView();
    private static final NumberGenerator numberGenerator = new RandomNumberGenerator();
    private int maxCarPosition = 0;
    private String[] carNames;
    private int tryNum;
    private static final int MOVE_CONDITION = 4;

    public void start() {
        this.carNames = view.scanCarNames();
        this.tryNum = view.scanTryNum();
        view.printResultNotice();
        run();
        RacingWinnerFinder winnerFinder = new RacingWinnerFinder(this.cars);
        RacingCar[] winners = winnerFinder.findWinners(this.maxCarPosition);
        String[] winnerNames = new String[winners.length];
        for (int i=0; i<winners.length; i++){
            winnerNames[i] = winners[i].name();
        }
        view.printWinner(winnerNames);
    }

    // ==============================
    // 🔹 Internal logic methods
    // ==============================
    private void initializeCars(int carNum) {
        this.cars = new RacingCar[carNum];
        for (int i = 0; i < carNum; i++) {
            cars[i] = new RacingCar(MOVE_CONDITION, numberGenerator, carNames[i]);
        }
    }

    private void run() {
        int[] positions = new int[carNames.length];
        initializeCars(carNames.length);
        for (int i = 0; i < tryNum; i++) {
            for (int j = 0; j < carNames.length; j++) {
                cars[j].move();
                if (cars[j].position() > this.maxCarPosition) {
                    this.maxCarPosition = cars[j].position();
                }
                positions[j] = cars[j].position();
            }
            view.printResult(positions);
        }
    }
}
