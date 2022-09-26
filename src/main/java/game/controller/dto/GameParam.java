package game.controller.dto;

public class GameParam {

    private final int countOfCar;

    private final int countOfRound;

    public GameParam(int countOfCar, int tryNum) {
        this.countOfCar = countOfCar;
        this.countOfRound = tryNum;
    }

    public int getCountOfCar() {
        return countOfCar;
    }

    public int getCountOfRound() {
        return countOfRound;
    }
}
