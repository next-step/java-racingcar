package step5.domain;

import step5.domain.dto.ResultOfCar;
import step5.exception.RacingGameException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private Winners(){}

    public static List<String> decideWinner(List<ResultOfCar> gameRoundResult) {
        int max = gameRoundResult.stream()
                .mapToInt(ResultOfCar::getPosition)
                .max()
                .orElseThrow(() -> new RacingGameException("winner가 없습니다"));

        return gameRoundResult.stream()
                .filter(r -> (r.getPosition() == max))
                .map(ResultOfCar::getCarName)
                .collect(Collectors.toList());


    }

}
