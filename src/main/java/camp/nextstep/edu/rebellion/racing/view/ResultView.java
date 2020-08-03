package camp.nextstep.edu.rebellion.racing.view;

import camp.nextstep.edu.rebellion.racing.domain.Record;
import camp.nextstep.edu.rebellion.racing.domain.SnapShotEntry;

import java.util.stream.Collectors;

public class ResultView {
    private static final String ROUND_TITLE = "[%4d] ROUND";
    private static final String WINNER_DELIMITER = ",";
    private static final String POSITION_LANE = "-";
    private static final String ENTER = "\n";

    public static void showResult(Record record) {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        for (SnapShotEntry snapShotEntry : record.getSnapShots()) {
            builder.append(String.format(ROUND_TITLE, round++)).append(ENTER);
            builder.append(generatePane(snapShotEntry));
        }

        builder.append(generateWinners(record.getFinalRoundSnapShot()) + "가 최종 우승했습니다");
        System.out.println(builder.toString());
    }

    private static String generatePane(SnapShotEntry snapShotEntry) {
        StringBuilder builder = new StringBuilder();
        snapShotEntry.getCars()
                .forEach(car -> builder
                        .append(makeLane(car.getName(), car.getPosition())).append(ENTER)
                );
        return builder.toString();
    }

    private static String generateWinners(SnapShotEntry snapShotEntry) {
        return snapShotEntry.getWinners().stream()
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private static String makeLane(String name, int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(":");
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_LANE);
        }
        return builder.toString();
    }
}
