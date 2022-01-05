package service;

import repository.Cars;
import view.View;


public class Game {
    private Cars cars;
    private View view;
    private int gameTurn;

    public Game() {
        this.view = new View();
        gameReady();
    }

    private void gameReady() {
        String carsName = view.enterCarsName();
        cars = new Cars(carsName);
        gameTurn = view.enterGameTurn();
    }

    public void gameStart() {
        view.printTurnStart();
        for (int i = 0; i < gameTurn; i++) {
            carRacing();
        }
        findWinner();
    }

    public void carRacing() {
        view.printTurnResult(cars.carsMove());
    }

    public void findWinner() {
        int maxDistance = cars.findMaxDistance();
        view.printWinnerResult(cars.findMaxDistanceCar(maxDistance));
    }

}
