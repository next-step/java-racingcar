package RacingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> racingCars;
    private int numOfCar;
    private int numOfTry;
    private String[] nameOfCars;
    private Rule rule = new DefaultRule();
    private InputView inputView= new InputView();


    public RacingGame(){
        racingCars = new ArrayList<Car>();
    }

    public void getInputValue(){
        this.nameOfCars = inputView.inputNameOfCars();
        this.numOfCar = this.nameOfCars.length;
        this.numOfTry = inputView.inputNumOfTry();
    }


    public void doRacingGame(){

        getInputValue();
        prepareGame(numOfCar);
        playGameNumOfTry(numOfTry);

    }

    public void playGameNumOfTry(int numOfTry) {
        int numOfPlayed = 0;
        while(numOfPlayed++ < numOfTry){
            
            racingCars
                    .forEach(car -> rule.playRule(car));
            
            racingCars
                    .forEach(car-> ResultView.viewResult(car));

            System.out.println();
        }
    }

    public void prepareGame(int numOfCar) {

        for(int i = 0; i < numOfCar; i ++){
            racingCars.add(new Car(this.nameOfCars[i]));
        }
    }

}
