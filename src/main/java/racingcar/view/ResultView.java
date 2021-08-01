package racingcar.view;

import racingcar.domain.RaceResult;
import racingcar.dto.CarDto;

import java.util.List;

import static racingcar.domain.RaceResult.RoundResult;

public class ResultView {
    private static final String INDICATION = "-";
    private static final String DELIMITER = ", ";

    public static void print(RaceResult raceResult) {
        System.out.println("실행 결과");
        for (RoundResult roundResult : raceResult.getRoundResults()) {
            System.out.println(roundResult.getRound() + "라운드");
            printCars(roundResult.getCarDtos());
        }
        printWinners(raceResult.getWinners());
    }

    private static void printCars(List<CarDto> carDtos) {
        for (CarDto car : carDtos) {
            System.out.print(car.getName() + " : ");

            printIndication(car.getPosition());
        }
        System.out.println();
    }

    private static void printIndication(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print(INDICATION);
        }
        System.out.println();
    }

    private static void printWinners(List<String> winners) {
        System.out.print(String.join(DELIMITER, winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
