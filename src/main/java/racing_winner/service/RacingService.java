package racing_winner.service;

import racing_winner.domain.RacingCar;
import racing_winner.utils.CommonUtils;
import racing_winner.utils.RacingUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private String[] carList;

    public List<RacingCar> setInitialCarList(int round, String carNames){
        RacingUtils.checkInputValue(round, carNames);
        carList = RacingUtils.splitCarArray(carNames);
        RacingUtils.checkValidateArray(carList);

        List<RacingCar> racingCarList = new ArrayList<>();

        for (String name : carList){
            RacingCar racingCar = new RacingCar(name);
            racingCarList.add(racingCar);
        }

        return racingCarList;
    }

    private boolean randomPlay() {
        int randomNumber = CommonUtils.randomNumber();
        CommonUtils.checkRandomNumber(randomNumber);
        return CommonUtils.compareNumber(randomNumber);
    }

    private void race(RacingCar racingCar) {
        if (randomPlay()) {
            racingCar.move();
        }
    }

    public List<RacingCar> exec(List<RacingCar> racingCarList){
        for (RacingCar racingCar : racingCarList){
            race(racingCar);
        }
        return racingCarList;
    }

}
