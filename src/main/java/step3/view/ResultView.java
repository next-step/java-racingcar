package step3.view;

import step3.dto.CarStatusDto;
import step3.dto.RacingResultDto;

import java.util.List;

public class ResultView {

    public static void displayCurrentCarsLocation(List<CarStatusDto> cars) {
        for (CarStatusDto carStatus : cars) {
            displayCarLocation(carStatus);
        }
        System.out.println();
    }

    private static void displayCarLocation(CarStatusDto carStatus) {
        System.out.print(carStatus.getName() + " : ");
        for (int i = 0; i < carStatus.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void displayWinners(RacingResultDto dto) {
        for (String winner : dto.getWinners()) {
            System.out.print(winner + " ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
