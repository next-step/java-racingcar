package service;

import repository.Cars;
import view.View;

import java.util.List;
import java.util.Random;

public class Game {
    CarService carService;
    View view = new View();
    int gameTurn;
    static final int RANDOM_NUMBER_BOUND = 10;

    public Game() {
        gameStart();
    }

    private void gameStart() {
        String carsName = view.enterCarsName();
        carService = new CarService(carsName);
        gameTurn = view.enterGameTurn();
        System.out.println("실행결과");
        for (int i = 0; i < gameTurn; i++) {
            carRacing();
        }
        findWinner();
    }

    public void carRacing() {
        for (int i = 0; i < carService.getCars().size(); i++) {
            int randomNumber = makeRandomNumber();
            carService.carsMove(i, randomNumber);
        }
        view.printTurnResult(carService.getCars());
    }

    public int makeRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void findWinner() {
        int maxDistance = carService.findMaxDistance();
        List<String> winner = carService.findMaxDistanceCar(maxDistance);
        view.printWinnerResult(winner);
    }

}
