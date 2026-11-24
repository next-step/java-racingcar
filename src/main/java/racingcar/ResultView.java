package racingcar;

public class ResultView {

    private static final String NAME_POSITION_DELIMITER = " : ";

    public void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTurn(TurnResult turnResult) {
        for (CarStatus status : turnResult.statuses()) {
            System.out.println(toLine(status));
        }
        System.out.println();
    }

    static String toLine(CarStatus status) {
        return status.name() + NAME_POSITION_DELIMITER + toDashes(status.position());
    }

    static String toDashes(int position) {
        return "-".repeat(position);
    }
}
