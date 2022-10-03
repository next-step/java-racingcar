package thirdstep.logic;

import thirdstep.View.InputView;
import thirdstep.View.ResultView;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        int raceCount = InputView.inputRaceCount();
        int carCount = InputView.inputCarCount();

        for(int i =0; i < carCount; i++) {
            Car car = new Car();
        }

        ArrayList<Car> carArrayList = Car.getCarArrayList();

        for( int i = 0; i < raceCount; i++){
            Race.startOneRace(carArrayList, carCount);
            ResultView.printOneRace(carArrayList);
        }
    }
}
