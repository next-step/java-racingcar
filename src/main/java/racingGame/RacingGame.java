package racingGame;

import racingGame.model.RacingCar;
import racingGame.model.RacingCarVO;
import racingGame.util.Lottery;

import java.util.*;

public class RacingGame {
    private static int LESS_MOVE_RANGE = 3;
    private static int GREATER_MOVE_RANGE = 11;
    private static String ERROR_NOT_FINISHD_RACE = "아직 경주가 끝나지 않았습니다.";
    private ArrayList<RacingCar> racingCars = new ArrayList<>();
    private String[] carNames;
    private int times;
    private int remainTimes;

    RacingGame(String[] carNames, int times) {
        this.carNames = carNames;
        this.times = times;
        this.remainTimes = times;

        this.initRacingCars();
    }

    public void move() {
        if (this.remainTimes > 0) {
            this.moveCars();
            this.remainTimes -= 1;
        }
    }

    public void moveCars() {
        for (RacingCar racingCar : this.racingCars) {
            if (this.isForward(Lottery.getLotteryNumber())) {
                racingCar.move();
            }
        }
    }

    public boolean isForward(int number) {
        return number > LESS_MOVE_RANGE && number < GREATER_MOVE_RANGE;
    }

    public boolean hasRemainTime() {
        return this.remainTimes > 0;
    }

    public List<RacingCarVO> getRacingCarSnapshots() {
        List<RacingCarVO> snapshots = new ArrayList<>();
        for (RacingCar racingCar : this.racingCars) {
            snapshots.add(new RacingCarVO(racingCar.getName(), racingCar.getPosition()));
        }

        return snapshots;
    }

    public List<RacingCarVO> getFinishedCarSnapshots() {
        if (hasRemainTime()) {
            throw new IllegalStateException(ERROR_NOT_FINISHD_RACE);
        }

        return this.getRacingCarSnapshots();
    }

    private void initRacingCars() {
        if (this.carNames == null || this.carNames.length < 1 || this.times < 0) {
            return;
        }

        // 경주용 자동차 초기화
        for (String carName : this.carNames) {
            this.racingCars.add(new RacingCar(carName));
        }
    }
}
