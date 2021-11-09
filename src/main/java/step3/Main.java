package step3;

public class Main {

    public static void main(String[] args) throws Exception {
        GameOutput.println("자동차는 몇 대인가요?");
        int numberOfCar = GameInput.readInt();
        GameOutput.println("몇 번 시도할 것인가요?");
        int numberOfRound = GameInput.readInt();

        GameOutput.println("실행 결과");
        CarRacingGame carRacingGame = new CarRacingGame(numberOfCar, numberOfRound);
        carRacingGame.start();
    }
}
