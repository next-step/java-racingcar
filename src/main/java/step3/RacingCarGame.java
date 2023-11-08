package step3;

public class RacingCarGame {
    public static void main(String[] args) {
        CarRacing racing = new CarRacing(new RandomNumMovingStrategy());
        racing.startGame();
    }
}
