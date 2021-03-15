package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {
    private Round round;
    private CarRacing carRacing;

    public CarRacingController(Round round, CarRacing carRacing) {
        this.round = round;
        this.carRacing = carRacing;
    }

    public List<CarResultDto> startCarRacing() {
        List<CarResultDto> carResultDtoList = new ArrayList<>();

        while (round.isRoundContinue()) {
            carRacing.moveForward();
            carResultDtoList.add(new CarResultDto(carRacing.getCarList(), carRacing.getWinnerCarNames()));
            round.reduceRound();
        }

        return carResultDtoList;
    }

}
