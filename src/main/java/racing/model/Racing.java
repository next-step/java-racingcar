package racing.model;


public class Racing {
    private Cars cars = new Cars();
    private int playCount = 0;

    public void prepareRacing(int carCount, int playCount) {
        this.playCount = playCount;
        this.cars.prepareCars(carCount);
    }

    public Cars participants() {
        return this.cars;
    }

    public Boolean endGame(int gameCount) {
        return this.playCount == gameCount ? true : false;
    }
}
