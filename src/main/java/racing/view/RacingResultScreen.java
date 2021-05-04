package racing.view;

import racing.domain.Winners;
import racing.service.CarDto;
import racing.service.RacingResult;

import java.util.List;

public class RacingResultScreen {
    private static final String DISTANCE_INDICATION = "-";

    public void print(RacingResult racingResult) {
        System.out.println("실행 결과");
        racingResult.getRoundResults()
                .forEach(roundResult -> printCars(roundResult.getCarDtos()));
        printWinners(racingResult.getWinners());
    }

    private void printCars(List<CarDto> carDtos) {
        carDtos.forEach(carDto -> {
            System.out.print(carDto.getCarName() + ":");
            printDashes(carDto.getDistance());
        });
        System.out.println();
    }

    private void printDashes(int distance) {
        for (int i = 0; i < distance; i++) {
            System.out.print(DISTANCE_INDICATION);
        }
        System.out.println();
    }

    private void printWinners(Winners winners) {
        System.out.print(winners + "가 최종 우승했습니다.");
    }
}
