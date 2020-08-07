package com.hskim.nextstep.step03.ui;

import com.hskim.nextstep.step02.utils.StringUtils;
import com.hskim.nextstep.step03.model.Racing;
import com.hskim.nextstep.step03.model.RacingCar;
import com.hskim.nextstep.step03.racing.RacingCarSimulator;

import java.util.Map;
import java.util.stream.Collectors;

public class ResultView extends View {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printRacingSimulateResult(RacingCarSimulator racingCarSimulator) {

        printPhraseToConsole("실행 결과");

        for (Racing racing : racingCarSimulator.getRacingHistory()) {

            printRacingResult(racing);
        }

        printPhraseToConsole(getWinnersString(racingCarSimulator) + "가 최종 우승했습니다.");
    }

    private void printRacingResult(Racing racing) {

        Map<String, Integer> record = racing.getRecordMap();

        printPhraseToConsole(" === GAME No." + racing.getRacingNo() + " ===");

        for (String carName : record.keySet()) {
            printPhraseToConsole(makeMoveProgressString(carName, record.get(carName)));
        }

        printPhraseToConsole("");
    }

    private String makeMoveProgressString(String carName, int totalDistance) {

        return carName + " : " + StringUtils.repeat(DISTANCE_SYMBOL, totalDistance);
    }

    private String getWinnersString(RacingCarSimulator racingCarSimulator) {

        return racingCarSimulator.findWinners().stream()
                .map(RacingCar::getCarName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
