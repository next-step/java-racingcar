package RacingCar;

import RacingCar.model.Result;

import java.util.List;

public class ResultView {

    static void print(List<Result> results) {
        results.forEach(stage -> {
            printStageResult(stage);
        });
    }

    private static void printStageResult(Result result) {
        result.getCars().forEach(car -> {
            System.out.println(getMoveString(car.getMove()));
        });
        System.out.println();
    }


    private static String getMoveString(int count) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append('-');
        }
        return stringBuilder.toString();
    }

}