package step3_racing_car;

public class GameRound {
    private RacingCars racingCars;
    public GameRound(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    // game round 진행시 이동 전략을 선택할 수 있다.
    void progressAllRound(int roundCount, MovingStrategy movingStrategy) {
        for (int i = 0; i < roundCount; i++) {
            racingCars.movePosition(movingStrategy);
            InputOutputView.printRoundResult(racingCars);
        }
    }
}
