package racinggame.view;

import racinggame.domain.Cars;

public class ResultView {

    private static final String DASH = "-";

    private Cars cars;
    private int count;

    public ResultView(Cars cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void resultRacing() {
        System.out.print("실행 결과");
        for (int i = 0; i < count; i++) {
            roundHistory(i);
            System.out.println("");
        }
    }

    private void roundHistory(int round) {
        for (Integer record : cars.getRacingHistory(round)) {
            printRecord(record);
        }
    }

    private void printRecord(int record) {
        StringBuilder racingRecord = new StringBuilder();
        for (int j = 0; j < record; j++) {
            racingRecord.append(DASH);
        }
        System.out.print("\n" + racingRecord);
    }
}
