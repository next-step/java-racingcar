package step3.controller;

import step3.model.Car;
import step3.view.ResultView;

public class RaceManager {
    private static final int THRETHOLD = 4;
    private static final int RAND_THRETHOLD = 10;
    private final int NUM_OF_CAR;
    private final int NUM_OF_CYCLE;

    public Car[] cars;

    public RaceManager(int NUM_OF_CAR, int NUM_OF_CYCLE) {
        this.NUM_OF_CAR = NUM_OF_CAR;
        this.NUM_OF_CYCLE = NUM_OF_CYCLE;
        cars = new Car[NUM_OF_CAR];
    }
    public void inputCheck() {
        CarManger.inputCarCheck(NUM_OF_CAR);
        CycleManager.inputRoundCheck(NUM_OF_CYCLE);
    }

    public Car[] makeCarAry() {
        System.out.println(NUM_OF_CAR);
        for (int i = 0; i < NUM_OF_CAR; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    public void raceByCycle() {
        for (int i = 0; i <= NUM_OF_CYCLE; i++) {
            raceByCar();
        }
    }

    public void raceByCar() {
        ResultView rv = new ResultView();
        for (int carNumber = 0; carNumber < NUM_OF_CAR; carNumber++) {
            rv.showCarLocation(cars[carNumber]);
            randMove(carNumber);
        }
        System.out.println();
    }

    public void randMove(int carNumber) {
        int rdNum = RandomNumber.getRandomNumber(RAND_THRETHOLD);
        if (rdNum >= THRETHOLD) {
            cars[carNumber].position++;
        }
    }
}
