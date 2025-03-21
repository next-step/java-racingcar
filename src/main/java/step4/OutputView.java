package step4;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void printRaceProgress(List<CarStatus> carStatuses) {
        System.out.println("실행 결과");
        for (CarStatus carStatus : carStatuses) {
            System.out.println(carStatus.getName() + ":" + "-".repeat(carStatus.getPosition()));
        }
    }

    public void printWinners(List<CarStatus> winnerStatuses) {
        List<String> winners = winnerStatuses.stream().map(CarStatus::getName).collect(Collectors.toList());
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }
}
