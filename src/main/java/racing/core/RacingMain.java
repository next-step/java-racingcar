package racing.core;

import racing.view.InputView;
import racing.view.ResultView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.start();
        RacingDto racingDto = inputView.getRacingDto();
        List<Car> carList = Car.makeCarList(racingDto.getCarCount());
        ResultView resultView = ResultView
                .builder()
                .racingDto(racingDto)
                .carList(carList)
                .build();
        resultView.print();
    }
}
