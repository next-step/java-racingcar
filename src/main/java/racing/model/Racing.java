package racing.model;


public class Racing {
    private Cars cars = new Cars();
    private int playCount = 0;

    public void prepareRacing(String carNames, int playCount) {
        this.playCount = playCount;
        this.cars.prepareCars(carNames);
    }

    public Cars participants() {
        return this.cars;
    }

    public Boolean endGame(int gameCount) {
        return this.playCount == gameCount ? true : false;
    }
}
