package step4;

public class Main {

    public static void main(String[] args) {
        int carCount;
        int roundCount;
        String[] carNames;
        CarRacingGame carRacingGame;

        System.out.println("경주할 자동차의 이름을 입력하세요(이름은 쉼표 (,)를 기준으로 구분");
        carNames = GameInput.readCarNames();
        System.out.println("자동차는 몇 대인가요?");
        carCount = GameInput.readInt();
        System.out.println("몇 번 시도할 것인가요?");
        roundCount = GameInput.readInt();

        System.out.println("실행 결과");
        carRacingGame = new CarRacingGame(carCount, carNames);
        for (int i = 0; i < roundCount; i++) {
            carRacingGame.moveCars();
            GameOutput.printCarPaths(carRacingGame);
            System.out.println();
        }
    }
}
