package RacingGame;

import RacingGame.domain.Car;
import RacingGame.domain.Cars;
import RacingGame.domain.DefaultRule;
import RacingGame.domain.Rule;
import RacingGame.dto.CarDto;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {

    private Cars racingCars;
    private String[] nameOfCars;
    private int numOfCar;


    public RacingGame(){}

    public RacingGame(Cars cars){
        racingCars = cars;
    }

    public void getInputValue(String[] nameOfCars){
        this.nameOfCars = nameOfCars;
        this.numOfCar = nameOfCars.length;
    }

    public Cars playGame() {
            racingCars.playGame();
            return racingCars;
    }

    public void prepareGame() {

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < this.numOfCar; i ++){
            cars.add(new Car(this.nameOfCars[i]));
        }
        racingCars = new Cars(cars);
    }

    public List<String> getWinners() {
        return racingCars.getWinners();
    }

    public List<CarDto> getCarDtos(){
        return racingCars.getCarDtos();
    }

}
