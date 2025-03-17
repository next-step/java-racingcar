package car_racing.view.model;

import java.util.List;

public class UserInput {
    private final List<String> namesOfCars;
    private final int numOfGame;

    public UserInput(List<String> namesOfCars, int numOfGame) {
        this.namesOfCars = namesOfCars;
        this.numOfGame = numOfGame;
    }

    public List<String> getNamesOfCar() {
        return namesOfCars;
    }

    public int getNumOfGame() {
        return numOfGame;
    }
}
