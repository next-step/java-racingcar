package racingCar;

import java.util.List;

public class ResultView {

    public void resultOfCars(Cars cars){
        RandomNumber randomNumber = new RandomNumber();
        for (int i=0; i<cars.carsSize(); i++) {
            System.out.println((cars.makePosition(i)));
            int temporaryRandomNumber = randomNumber.createRandomNumber();
            cars.carsMove(i, temporaryRandomNumber);
        }
        System.out.println("");
    }

}
