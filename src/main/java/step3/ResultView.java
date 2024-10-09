package step3;

public class ResultView {

    public static void result(GameResults gameResults) {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameResults.getSize(); i++) {
            printRoundResult(gameResults.getRoundResult(i));
            System.out.println();
        }
    }

    private static void printRoundResult(RoundResult roundResult) {
        for (int j = 0; j < roundResult.getSize(); j++) {
            System.out.println(appendDistanceBar(roundResult.getCarDistance(j)));
        }
    }

    private static StringBuilder appendDistanceBar(int carDistance) {
        StringBuilder distance = new StringBuilder();
        for (int k = 0; k < carDistance; k++) {
            distance.append("-");
        }
        return distance;
    }
}
