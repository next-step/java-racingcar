package carRacing.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private static int MINUMUN_DEMAND = 1;
    private GamePoint gamePoint;
    private RacingCarGroup racingCarGroup;
    private int racingHighPosition;

    public RacingGame(RacingCarGroup racingCarGroup, GamePoint gamePoint) {
        verifyRacingCarGroup(racingCarGroup);
        this.racingCarGroup = racingCarGroup;
        this.gamePoint = gamePoint;
    }

    public RacingCarGroup race(){
        for (Car car : racingCarGroup.getRacingCars()) {
            int position = car.move(gamePoint.getGamePoint());
            registerHighPosition(position);
        }
        return new RacingCarGroup(racingCarGroup.getRacingCars());
    }

    public RacingCarGroup gameResult() {
        List<Car> winner = racingCarGroup.getRacingCars().stream()
                .filter(car -> car.getPosition() == racingHighPosition)
                .collect(Collectors.toList());
        return new RacingCarGroup(winner);
    }

    private void registerHighPosition(int position) {
        if (racingHighPosition < position) racingHighPosition = position;
    }

    private void verifyRacingCarGroup(RacingCarGroup racingCars) {
        if(racingCars == null || racingCars.getRacingCars().size() < MINUMUN_DEMAND) {
            throw new IllegalArgumentException("게임을 위해최소한 하나 이상의 자동차가 필요합니다.");
        }
    }
}
