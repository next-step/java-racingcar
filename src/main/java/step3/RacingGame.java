package step3;

public class RacingGame {

    private Cars cars;

    public RacingGame(int carCount) {
        this.cars = new Cars(carCount);
    }

    public void play() {
        cars.play();
    }

    public String getPlayResult(){
        return cars.getWayResult();
    }

}
