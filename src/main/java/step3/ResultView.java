package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private List<Integer> carPositions;
    private List<String> resultCarPositions;

    public ResultView() {
    }

    public ResultView(List<Integer> carPositions) {
        this.carPositions = carPositions;
        initResultcarPositions(carPositions);
    }

    private void initResultcarPositions(List<Integer> carPositions) {
        resultCarPositions = new ArrayList<>();
        for(int i=0; i<carPositions.size(); i++){
            resultCarPositions.add("");
        }
    }

    public void setCarPositions() {
        for (int i = 0; i < carPositions.size(); i++) {
            appendDash(i);
        }
    }

    public void appendDash(int index) {
        StringBuilder builder = new StringBuilder();
        int carPosition = carPositions.get(index);
        IntStream.range(0, carPosition).forEach(i -> {
            builder.append("-");
        });

        resultCarPositions.set(index, builder.toString());
    }

    public void printRacingResult() {
        resultCarPositions.forEach(System.out::println);
    }

    public List<String> getResultCarPositions() {
        return resultCarPositions;
    }
}
