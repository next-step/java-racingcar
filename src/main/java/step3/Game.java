package step3;

public class Game {
    public int roundCount;

    public Cars cars = new Cars();
    public Car car = new Car();

    public Game() {}

    public Game(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount(){
        return this.roundCount;
    }

    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            car = cars.getCar(i);
            car.move(RandomGenerator.getRandomNumber());
            ResultView.drawTravelDistance(car);
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }

    public void execround() {
        for (int i = 0; i < roundCount; i++) {
            playRound();
        }
    }
}