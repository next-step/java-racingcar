package step3;

public class Game {
    private int roundCount;
    public static Cars cars = new Cars();

    public Game(int roundCount) {
        this.roundCount = roundCount;
    }

    public int getRoundCount(){
        return this.roundCount;
    }


    public void playRound(){
        for (int i = 0; i < cars.getSize(); i++) {
            cars.getCarListOne(i).move(RandomGenerator.getRandomNumber());
            ResultView.drawTravelDistance(cars.getCarListOne(i));
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