package step_3;

import java.util.List;

public class GameResultView {

    public static void printRacingGames(List<RacingResult> lapHistory){
        lapHistory.forEach(lap -> {
            GameResultView.printRacingResult(lap.gameStatus());
            System.out.print("\n");
        });
    }

    public static void printRacingResult(List<Integer> carsOnCounse) {
        carsOnCounse.forEach(courseIndex -> System.out.println(printResult(courseIndex)));
    }

    private static String printResult (Integer courseIndex){
        StringBuilder stringBuilder = new StringBuilder();
        for (int currentIndex = 0; currentIndex <= courseIndex; currentIndex++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }
}
