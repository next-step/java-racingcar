package racing.model;


public class RacingModel {
    private CarsModel cars = new CarsModel();
    private int playCount = 0;

    public void prepareRacing(int carCount, int playCount) {
        this.playCount = playCount;
        this.cars.prepareGame(carCount);
    }

    public CarsModel participants() {
        return this.cars;
    }

    public Boolean endGame(int gameCount) {
        return this.playCount == gameCount ? true : false;
    }
}
