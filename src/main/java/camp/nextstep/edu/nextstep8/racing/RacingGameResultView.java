package camp.nextstep.edu.nextstep8.racing;

import java.util.List;

public class RacingGameResultView {
    private static String DISPLAY_SYMBOL = "-";
    private List<Integer> record;

    private int carNumbers;
    private int raceTimes;

    public RacingGameResultView(List<Integer> record, int carNumbers, int raceTimes) {
        this.carNumbers = carNumbers;
        this.record = record;
        this.raceTimes = raceTimes;
    }

    public void showResult() {
        int positionIndex = 0;
        for(int i = 0; i < raceTimes; i++) {
            System.out.println("=====[" + (i+1) + " ROUND" + "]=====");
            for(int j = 0; j < carNumbers; j++) {
                printSymbol(record.get(positionIndex++));
                System.out.println();
            }
            System.out.println();
        }
    }

    private void printSymbol(int count) {
        for(int i = 0; i < count; i++) {
            System.out.print(DISPLAY_SYMBOL);
        }
    }
}

