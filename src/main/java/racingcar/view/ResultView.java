package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private final List<Integer> positions;

    public ResultView(List<Integer> positions) {
        this.positions = positions;
    }

    public String print() {
        String result = positions.stream()
            .map(position -> {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < position; i++) {
                    builder.append('-');
                }
                return builder;
            }).collect(Collectors.joining("\n"));

        return result;
    }


}
