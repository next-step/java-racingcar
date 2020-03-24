package RacingCar;

import java.util.List;

public class ResultView {


    static void print(List<List<Integer>> results) {

        results.forEach(stage -> {
            stage.forEach(count -> {
                System.out.println(getMoveString(count));
            });
            System.out.println();
        });
    }

    private static String getMoveString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

}

