package step3;

public class Game {
    private int roundCount;
    private int carCount;
    public static Cars cars = new Cars();
    public static Car car = new Car();

    public Game(int roundCount) {
        this.roundCount = roundCount;
    }

    public Game(int roundCount, int carCount) {
        this.roundCount = roundCount;
        this.carCount = carCount;
    }

    public int getRoundCount(){
        return this.roundCount;
    }


    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            car = cars.getCarList(i);
            car.move(RandomGenerator.getRandomNumber());
            ResultView.drawTravelDistance(car);
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }

    public void execround(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            playRound();
        }
    }
}