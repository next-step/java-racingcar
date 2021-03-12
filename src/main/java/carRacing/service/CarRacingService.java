package carRacing.service;

import carRacing.domain.*;
import carRacing.dto.UserInput;

import java.util.List;

public class CarRacingService {

    private final CarFactory carFactory = new CarFactory();
    private final View view = new View();
    private final Judge judge = new Judge();
    private final Game game = new Game();

    public void run(){
        UserInput userInput = view.getUserInput();
        List<Car> cars = carFactory.initCars(userInput);
        while(!judge.isGameOver(userInput)){
            cars = game.race(cars);
            view.printScoreboard(cars);
            judge.recordTime();
        }
    }
}
