package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int tryTime;
    private RacingCars racingCars;

    public Racing(int carNum, int tryTime) {
        racingCars = createRacingCar(carNum);
        this.tryTime = tryTime;
    }

    private RacingCars createRacingCar(int carNum) {
        List<RacingCar> racingCars = new ArrayList<>(carNum);
        for (int i = 0; i < carNum; i++) {
            racingCars.add(new RacingCar());
        }
        return new RacingCars(racingCars);
    }

//    public void startRace() {
//        for(int i = 0; i < tryTime; i++) {
//            moveCars();
//        }
//    }
//
//    private void moveCars() {
//        for(RacingCar racingCar: racingCars) {
//            int randomValue = generateRandomNum();
//            racingCar.move(()-> isMoving(randomValue));
//        }
//    }

    private boolean isMoving(int randomValue) {
        return randomValue >= Consts.MOVE_MIN_COUNT;
    }

    public RacingCars getRacingCar() {
        return racingCars;
    }
}
