package study.step3.domain;

import study.step3.dto.CarRacingDto;
import study.step3.view.InputView;
import study.step3.view.OutputView;

import java.util.List;

public class CarRacingController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        CarRacingController controller = new CarRacingController();
        controller.playCarRacing();
    }

    public void playCarRacing() {
        String[] carNames = inputView.inputCarNames();
        int countOfMove = inputView.inputCountOfMove();
        CarRacing carRacing = new CarRacing(List.of(carNames), countOfMove);

        List<CarRacingDto> resultOfPositions = carRacing.play();

        outputView.outputTextOfResult();
        for (int i = 0; i < countOfMove; i++) {
            CarRacingDto carRacingDto = resultOfPositions.get(i);
            outputView.outputPositionOfCarsWithName(List.of(carNames), carRacingDto.getPositionOfCars());
        }

        outputView.outputWinners(carRacing.findWinners());
    }
}
