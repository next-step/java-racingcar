package service;

import repository.Cars;
import view.View;

import java.util.Random;

public class Game {
    Cars cars;
    CarService carService = new CarService();
    View view = new View();
    int gameTurn;

    public Game() {
        gameStart();
    }

    private void gameStart() {
        String carsName = view.enterCarsName();
        cars = carService.readyCars(carsName);
        gameTurn = view.enterGameTurn();
        System.out.println("실행결과");
        for (int i = 0; i < gameTurn; i++) {
            racing();
        }
        findWinner();
    }

    public void racing() {
        Random random = new Random();
        for (int i = 0; i < cars.getCars().size(); i++) {
            int randomNumber = random.nextInt(10);
            carService.carsMove(i, randomNumber);
        }
        view.printTurnResult(cars.getCars());
    }

    public void findWinner() {
        int maxDistance = carService.findMaxDistance();
        carService.findMaxDistanceCar(maxDistance);
        view.printWinnerResult(cars.getWinner());
    }

}
