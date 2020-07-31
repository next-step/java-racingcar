package camp.nextstep.edu.rebellion.racing;

public class ResultView {
    private static final String ENTER = "\n";

    public static void showResult(Record record) {
        StringBuilder builder = new StringBuilder();
        int round = 1;
        for (String lane : record.getRecordLane()) {
            builder.append("ROUND").append(round++).append(ENTER);
            builder.append(lane).append(ENTER);
        }
        System.out.println(builder.toString());
    }
}
