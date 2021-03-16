package step3;

import java.util.ArrayList;
import java.util.List;

public class CarRacingController {
    private Round round;
    private CarRacing carRacing;

    private InputView inputView;

    public CarRacingController(Round round, CarRacing carRacing) {
        this.round = round;
        this.carRacing = carRacing;
    }

    public CarRacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public List<CarResultDto> startCarRacing() {
        List<CarResultDto> carResultDtoList = new ArrayList<>();

        while (round.isRoundContinue()) {
            carRacing.moveForward();
            carResultDtoList.add(new CarResultDto(carRacing.getCarList(), carRacing.findWinnerCarNames()));
            round.reduceRound();
        }

        return carResultDtoList;
    }

}
