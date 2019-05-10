package racing;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private int tryTime;
    private RacingCars racingCars;

    public Racing(String carNames[], int tryTime) {
        racingCars = createRacingCar(carNames);
        this.tryTime = tryTime;
    }

    private RacingCars createRacingCar(String carNames[]) {
        List<RacingCar> racingCars = new ArrayList<>(carNames.length);
        for(String carName : carNames){
            racingCars.add(new RacingCar(carName));
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

    public RacingCars getRacingCar() {
        return racingCars;
    }
}
