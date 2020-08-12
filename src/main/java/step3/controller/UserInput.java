package step3.controller;

public class UserInput {

    private int numOfCars;
    private int tries;

    public UserInput(int numOfCars, int tries) {
        this.numOfCars = numOfCars;
        this.tries = tries;
    }

    public int getnumOfCars() {
        return numOfCars;
    }

    public int getTries() {
        return tries;
    }
}
