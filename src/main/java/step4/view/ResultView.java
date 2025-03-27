package step4.view;

import step4.domain.RoundStatusDTO;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class ResultView {

    public static void printStatus(List<RoundStatusDTO> roundStatuses) {
        for(RoundStatusDTO roundStatus : roundStatuses) {
            String carName = roundStatus.getCarName();
            int position = roundStatus.getPosition();
            String result = carName + " : " + "-".repeat(position);
            System.out.println(result);
        }
    }

    public static void printWinners(List<RoundStatusDTO> winners) {
        List<String> winnersList = new ArrayList<>();

        for(RoundStatusDTO winner : winners) {
            String carName = winner.getCarName();
            winnersList.add(carName);
        }

        System.out.println(String.join(", ", winnersList) + "가 우승했습니다.");
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
