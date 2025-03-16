package car_racing.view.model;

public class UserInput {
    private final int numOfCar;
    private final int numOfGame;

    public UserInput(int numOfCar, int numOfGame) {
        this.numOfCar = numOfCar;
        this.numOfGame = numOfGame;
    }

    public int getNumOfCar() {
        return numOfCar;
    }

    public int getNumOfGame() {
        return numOfGame;
    }
}
