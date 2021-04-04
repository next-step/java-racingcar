package RacingGame;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private List<Car> racingCars;
    private String[] nameOfCars;
    private int numOfCar;
    private Rule rule = new DefaultRule();


    public RacingGame(){
        racingCars = new ArrayList<Car>();
    }

    public void getInputValue(String[] nameOfCars){
        this.nameOfCars = nameOfCars;
        this.numOfCar = nameOfCars.length;
    }

    public List<Car> playGame() {
            racingCars
                    .forEach(car -> rule.playRule(car));
            
            return this.racingCars;
    }

    public void prepareGame() {

        for(int i = 0; i < this.numOfCar; i ++){
            racingCars.add(new Car(this.nameOfCars[i]));
        }
    }

    public List<String> getWinners(){
        Integer maxLocation = getMaxLocation(this.racingCars);
        return namesOfWinner(maxLocation,this.racingCars);

    }

    public List<String> namesOfWinner(Integer maxLocation, List<Car> racingCars){

        return racingCars.stream()
                .filter(car -> car.isAt() == maxLocation )
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    public Integer getMaxLocation(List<Car> racingCars) {
        return racingCars.stream()
                .map(car -> car.isAt())
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoSuchElementException::new);

    }

}
