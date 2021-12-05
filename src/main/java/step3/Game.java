package step3;

public class Game {
    private int roundCount;
    public static Cars cars = new Cars();
    RandomGenerator randomGenerator = new RandomGenerator();


    public int getRoundCount(){
        return this.roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            cars.getCarList(i).move(randomGenerator.getRandomNumber());
            ResultView.drawTravelDistance(cars.getCarList(i));
            ResultView.drawLineBreak();
        }
        ResultView.drawLineBreak();
    }
}