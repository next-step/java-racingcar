package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.car.Car;
import racingcar.domain.car.RandomMovingStrategy;
import racingcar.dto.RacingCarRequestDto;
import racingcar.dto.RacingCarResponseDto;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingGameService racingGameService = new RacingGameService();
        ResultView resultView = new ResultView();

        String racingCarNames = InputView.inputRacingCars();
        int numberOfTime = InputView.inputRacingGameTimes();

        RacingCarRequestDto racingCarRequestDto = new RacingCarRequestDto(racingCarNames, numberOfTime);

        List<Cars> cars = racingGameService
                .executeRacingGameNumberOfTimes(racingCarRequestDto, new RandomMovingStrategy());
        List<Car> winners = racingGameService.findWinnerInRacingScores(cars);

        RacingCarResponseDto racingCarResponseDto = new RacingCarResponseDto(cars, winners);

        resultView.print(racingCarResponseDto.getCars());
        resultView.printWinner(racingCarResponseDto.getWinners());
    }
}
