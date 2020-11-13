package racingcar.ui;

import racingcar.domain.CarDTO;

import java.util.List;

public class ResultView {

    public void showRacingResult(List<CarDTO> racingResult) {
        for (CarDTO carDTO : racingResult) {
            System.out.println(
                    new StringBuilder().append(carDTO.getName())
                    .append(" : ")
                    .append(carDTO.getPosition())
            );
        }

        System.out.println();
        System.out.println();
    }

}
