package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.dto.CarDTO;

public class OutputView {

    public static final String CAR_PROGRESS = "-";

    public static void basicOutput() {
        System.out.println("실행 결과");
    }

    public static void outputProgress(List<CarDTO> roundResult) {
        roundResult.forEach(carDTO -> System.out.println(
            carDTO.getName() + " : " + CAR_PROGRESS.repeat(carDTO.getPosition()))
        );
    }

    public static void outputWinner(List<CarDTO> winners) {
        System.out.println(winners.stream()
            .map(CarDTO::getName)
            .collect(Collectors.joining(",")) + "가 최종 우승했습니다.");
    }

}
