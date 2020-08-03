package camp.nextstep.edu.rebellion.racing;

public class ResultView {
    private static final String POSITION_LANE = "-";
    private static final String ENTER = "\n";

    public static void showResult(Record record) {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        for (SnapShotEntry snapShotEntry : record.getSnapShots()) {
            builder.append("ROUND " + round++).append(ENTER);
            builder.append(generatePane(snapShotEntry));
        }

        builder.append(record.getFinalRoundSnapShot().getWinners() + "가 최종 우승했습니다 :+1");
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

    private static String makeLane(String name, int position) {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(":");
        for (int i = 0; i < position; i++) {
            builder.append(POSITION_LANE);
        }
        return builder.toString();
    }
}
