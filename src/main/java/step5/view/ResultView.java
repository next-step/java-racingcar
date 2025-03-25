package step5.view;

import step5.domain.CarStatusDto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printRaceProgress(List<CarStatusDto> currentStatus) {
        System.out.println("실행 결과");
        for (CarStatusDto CarStatusDto : currentStatus) {
            System.out.println(CarStatusDto.getCarName() + ":" + "-".repeat(CarStatusDto.getPosition()));
        }
    }

    public static void printWinners(List<CarStatusDto> winnerStatuses) {
        List<String> winners = winnerStatuses.stream().map(CarStatusDto::getCarName).collect(Collectors.toList());
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

}
