package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Movement;
import racingcar.domain.TrialCoin;
import racingcar.domain.dto.CarDto;

public class RacingService {

    private final Movement movement;
    private final Cars cars;
    private final TrialCoin trialCoin;

    public RacingService(Movement movement, String[] names, int trials) {
        this.movement = movement;
        this.cars = Cars.ofNames(getTrimmedStrings(names));
        this.trialCoin = new TrialCoin(trials);
    }

    public void race() {
        cars.move(movement);
        trialCoin.decrease();
    }

    public boolean isRaceOnGoing() {
        return trialCoin.isCoinLeft();
    }

    public List<CarDto> getWinners() {
        return cars.findWinners().stream().map(CarDto::of)
                .collect(Collectors.toList());
    }

    public List<CarDto> getProgress() {
        return cars.getCarsInfo().stream().map(CarDto::of)
                .collect(Collectors.toList());
    }

    private List<String> getTrimmedStrings(String[] names) {
        return Arrays.stream(names)
                .map(String::trim)
                .collect(Collectors.toList());
    }

}
