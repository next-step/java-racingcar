package RacingCar.controller;

import NumberGenerator.*;
import RacingCar.model.*;
import RacingCar.view.RacingCarView;

public class RacingCarController {
    private RacingCars cars;
    private RacingCarView view;
    private int tryNum;

    public RacingCarController(RacingCars cars, RacingCarView view, int tryNum){
        this.cars = cars;
        this.view = view;
        this.tryNum = tryNum;
    }

    public void startRace(){
        view.printResultNotice();
        for (int i=0; i<tryNum; i++){
            cars.moveAll();
            view.printResult(cars.getCarsPosition());
        }
        view.printWinner(cars.getWinners());
    }
}
