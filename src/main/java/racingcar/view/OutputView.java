package racingcar.view;

import java.util.List;

public class OutputView {

    public void printStart() {
        System.out.println("실행 결과");
    }

    public void printRound(List<Integer> positions) {
        positions.stream().forEach(position -> {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < position; i++) {
                builder.append('-');
            }

            System.out.println(builder.toString());
        });

        System.out.println();
    }

}
