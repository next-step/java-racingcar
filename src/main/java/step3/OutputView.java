package step3;

import step3.dto.PositionResponse;
import step3.dto.RaceRoundResult;

import java.util.List;

public class OutputView {

    public static void draw(List<RaceRoundResult> response) {
        StringBuilder sb = new StringBuilder();

        for (RaceRoundResult raceRoundResult : response) {
            for (PositionResponse position : raceRoundResult.getValue()) {
                sb.append("-".repeat(position.getValue()));
                sb.append(System.lineSeparator());
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }
}
