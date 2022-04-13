package racingcar;

import java.util.List;

public class ResultView {

    private static final String PATH_SYMBOL = "-";

    public void printEveryLocation(List<Integer> resultLocations) {
        for (Integer resultLocation : resultLocations) {
            String currentLocationView = printResult(resultLocation);
            System.out.println(currentLocationView);
        }
        System.out.println();
    }

    public String printResult(int resultLocation) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        while (count < resultLocation) {
            stringBuilder.append(PATH_SYMBOL);
            count++;
        }
        return stringBuilder.toString();
    }
}
