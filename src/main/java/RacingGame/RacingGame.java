package RacingGame;

import java.util.*;
import java.util.stream.Collectors;

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
        ResultView.viewWinner(getWinner(this.racingCars));

    }

    public void playGameNumOfTry(int numOfTry) {
        int numOfPlayed = 0;
        while(numOfPlayed++ < numOfTry){
            System.out.println();

            racingCars
                    .forEach(car -> rule.playRule(car));
            
            racingCars
                    .forEach(car-> ResultView.viewGame(car));

        }
    }

    public void prepareGame(int numOfCar) {

        for(int i = 0; i < numOfCar; i ++){
            racingCars.add(new Car(this.nameOfCars[i]));
        }
    }

    public List<String> getWinner(List<Car> racingCars){

        Integer maxLocation = racingCars.stream()
                .map(car -> car.isAt())
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);

        return racingCars.stream()
                .filter(car -> car.isAt() == maxLocation )
                .map(car -> car.carName())
                .collect(Collectors.toList());

    }

}
