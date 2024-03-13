package race.view;

import java.util.List;

public class OutputView {

    private static final String UNIT_MILEAGE = "-";

    public void printMileages(List<Integer> positions) {
        for (Integer position : positions) {
            if (position == 0) { // 일단 억지로라도 이렇게 했습니다. 더 생각해보겠습니다
                position = 1;
                System.out.println(UNIT_MILEAGE);
                continue;
            }
            System.out.println(UNIT_MILEAGE.repeat(position));
        }
    }

    public void printResultStatement() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public void printNewLine() {
        System.out.println("\n");
    }
}
