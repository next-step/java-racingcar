package carRacing.model;

public class RacingGame {

    private static int MINUMUN_DEMAND = 1;
    private GamePoint gamePoint;
    private RacingCars racingCars;
    private int gameBestPosition;

    public RacingGame(RacingCars racingCars, GamePoint gamePoint) {
        verifyRacingCarGroup(racingCars);
        this.racingCars = racingCars;
        this.gamePoint = gamePoint;
    }

    public RacingCars race(){
        for (Car car : racingCars.getRacingCars()) {
            int position = car.move(gamePoint.getGamePoint());
            registerBestPosition(position);
        }
        return new RacingCars(racingCars.getRacingCars());
    }

    public RacingCars gameResult() {
        return RacingWinner.pickOutWinners(racingCars, gameBestPosition);
    }

    private void registerBestPosition(int position) {
        if (gameBestPosition < position) gameBestPosition = position;
    }

    private void verifyRacingCarGroup(RacingCars racingCars) {
        if(racingCars == null || racingCars.getRacingCars().size() < MINUMUN_DEMAND) {
            throw new IllegalArgumentException("게임을 위해최소한 하나 이상의 자동차가 필요합니다.");
        }
    }
}
