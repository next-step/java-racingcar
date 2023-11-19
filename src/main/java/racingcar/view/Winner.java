package racingcar.view;

import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.COMMA;
import static racingcar.constant.Constant.ENTER;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringJoiner;

public class Winner {
    public String inform(String gameResult) {
        Map<String, Long> racingCarsAndPositions = createRacingCarsAndPosition(gameResult);
        long finishLine = findMaxPosition(racingCarsAndPositions);
        return findWinners(racingCarsAndPositions, finishLine);
    }

    private Map<String, Long> createRacingCarsAndPosition(String gameResult) {
        Map<String, Long> racingCarsAndPositions = new LinkedHashMap<>();
        for (String racingCarGameResult : gameResult.split(ENTER)) {
            addRacingCarAndPositionTo(racingCarGameResult, racingCarsAndPositions);
        }
        return racingCarsAndPositions;
    }

    private void addRacingCarAndPositionTo(String racingCarGameResult, Map<String, Long> racingCarsAndPositions) {
        String[] racingCarGameResultInfo = racingCarGameResult.split(COLON);
        String racingCar = racingCarGameResultInfo[0];
        Long position = countPosition(racingCarGameResultInfo[1]);
        racingCarsAndPositions.put(racingCar, position);
    }

    private Long countPosition(String position) {
        return (long) position.toCharArray().length;
    }

    private long findMaxPosition(Map<String, Long> racingCarsAndPositions) {
        long maxPosition = Long.MIN_VALUE;
        for (Long position : racingCarsAndPositions.values()) {
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    private String findWinners(Map<String, Long> racingCarsAndPositions, long maxPosition) {
        StringJoiner winners = new StringJoiner(COMMA);
        for (Entry<String, Long> racingCarAndPosition : racingCarsAndPositions.entrySet()) {
            addWinnerTo(maxPosition, racingCarAndPosition, winners);
        }
        return winners.toString();
    }

    private void addWinnerTo(long maxPosition, Entry<String, Long> racingCarAndPosition, StringJoiner winners) {
        if (isFinishLine(maxPosition, racingCarAndPosition)) {
            winners.add(racingCarAndPosition.getKey());
        }
    }

    private boolean isFinishLine(long maxPosition, Entry<String, Long> racingCarAndPosition) {
        return maxPosition == racingCarAndPosition.getValue();
    }
}
