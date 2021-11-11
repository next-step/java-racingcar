package step4;

public class Main {

    public static void main(String[] args) {
        System.out.println("자동차는 몇 대인가요?");
        int carCount = GameInput.readInt();
        System.out.println("몇 번 시도할 것인가요?");
        int roundCount = GameInput.readInt();

        System.out.println("실행 결과");
        CarRacingGame carRacingGame = new CarRacingGame(carCount);
        for (int i = 0; i < roundCount; i++) {
            carRacingGame.moveCars();
            GameOutput.printCarPaths(carRacingGame);
            System.out.println();
        }
    }
}
