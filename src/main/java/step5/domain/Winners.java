package step5.domain;

import step5.domain.dto.CarData;
import step5.exception.RacingGameException;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private Winners(){}

    public static List<String> decideWinner(List<CarData> gameRoundResult) {
        int max = gameRoundResult.stream()
                .mapToInt(CarData::getPosition)
                .max()
                .orElseThrow(() -> new RacingGameException("winner가 없습니다"));

        return gameRoundResult.stream()
                .filter(r -> (r.getPosition() == max))
                .map(CarData::getCarName)
                .collect(Collectors.toList());
    }

}
