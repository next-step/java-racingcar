package RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> racingCars;

    public RacingGame(){
        racingCars = new ArrayList<Car>();
    }

    public void doRacingGame(){
        InputView inputView = new InputView();
        int numOfCar = inputView.inputNumOfCar();
        int numOfTry = inputView.inputNumOfTry();

        prepareGame(numOfCar);
        playGameNumOfTry(numOfTry);

    }

    private void playGameNumOfTry(int numOfTry) {
        int numOfPlayed = 0;
        while(numOfPlayed++ < numOfTry){
            
            racingCars.stream()
                    .forEach(car -> car.stopOrMove());
            
            racingCars.stream()
                    .forEach(car-> ResultView.viewResult(car));

            System.out.println();
        }
    }

    private void prepareGame(int numOfCar) {

        for(int i = 0; i < numOfCar; i ++){
            racingCars.add(new Car());
        }
    }

}
