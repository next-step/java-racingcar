package service;

import repository.Cars;
import view.View;

import java.util.List;
import java.util.Random;

public class Game {
    Cars cars;
    CarService carService = new CarService();
    View view = new View();
    int gameTurn;
    static final int RANDOM_NUMBER_BOUND = 10;

    public Game() {
        gameStart();
    }

    private void gameStart() {
        String carsName = view.enterCarsName();
        cars = carService.readyCars(carsName);
        gameTurn = view.enterGameTurn();
        System.out.println("실행결과");
        for (int i = 0; i < gameTurn; i++) {
            carRacing();
        }
        findWinner();
    }

    public void carRacing() {
        Random random = new Random();
        for (int i = 0; i < cars.getCars().size(); i++) {
            int randomNumber = random.nextInt(RANDOM_NUMBER_BOUND);
            carService.carsMove(i, randomNumber);
        }
        view.printTurnResult(cars.getCars());
    }

    public void findWinner() {
        int maxDistance = carService.findMaxDistance();
        List<String> winner = carService.findMaxDistanceCar(maxDistance);
        view.printWinnerResult(winner);
    }

}
