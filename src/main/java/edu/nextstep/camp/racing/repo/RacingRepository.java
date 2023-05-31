package edu.nextstep.camp.racing.repo;

import edu.nextstep.camp.racing.model.Car;
import edu.nextstep.camp.racing.model.RacingResult;
import edu.nextstep.camp.racing.model.RacingStartInput;

import java.util.Random;

public class RacingRepository {
    private final Car[] cars;
    private final MoverCommander moveCommander = new MoverCommander();

    private final RacingStartInput racingStartInput;
    public RacingRepository(RacingStartInput racingStartInput) {
        this.racingStartInput = racingStartInput;
        int vehicleCnt = racingStartInput.getVehicleCnt();
        cars = new Car[vehicleCnt];

        for (int i = 0; i < vehicleCnt; i++){
            cars[i] =  new Car(racingStartInput.getMovingCnt());
        }
    }

    public void move(int racingIndex){
        for (Car car : cars) {
            car.move(moveCommander.isMove(), racingIndex);
        }
    }

    public RacingResult racingResult() {
        return new RacingResult(cars, racingStartInput.getMovingCnt());
    }

    private class MoverCommander {
        private static final int MOVE_MAX_BOUND = 10;
        private static final int MOVE_CONDITION = 4;

        private final Random random = new Random();

        boolean isMove(){
            return random.nextInt(MOVE_MAX_BOUND) >= MOVE_CONDITION;
        }
    }
}
