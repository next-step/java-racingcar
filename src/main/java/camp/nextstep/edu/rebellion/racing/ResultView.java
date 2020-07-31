package camp.nextstep.edu.rebellion.racing;

public class ResultView {
    public static void showResult(Record record) {
        int round = 1;
        for (String lane : record.getRecordLane()) {
            System.out.println("ROUND " + round++);
            System.out.println(lane);
        }
    }
}
