package carRacing;

public class RacingApplication {
    public static void main(String[] args) {
        // 유저로부터 파라미터 입력
        InputView inputView = new InputView();

        // 게임 초기화 및 경주 진행
        CarRacingGame carRacingGame = new CarRacingGame(inputView.getNumberOfCar(), inputView.getTryCount());
        carRacingGame.doGame();
    }
}
