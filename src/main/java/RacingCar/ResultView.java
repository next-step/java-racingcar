package RacingCar;

import RacingCar.model.Car;
import RacingCar.model.Result;

import java.util.List;

public class ResultView {


    static void print(List<Result> results) {
        results.forEach(stage -> {
            stage.getCars().forEach(count -> {
                System.out.println(getMoveString(count.getMove()));
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

