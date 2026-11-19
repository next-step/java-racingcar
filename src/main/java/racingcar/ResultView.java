package racingcar;

public class ResultView {

    public void printHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTurn(TurnResult turnResult) {
        for (int position : turnResult.positions()) {
            System.out.println(toDashes(position));
        }
        System.out.println();
    }

    static String toDashes(int position) {
        return "-".repeat(position);
    }
}
