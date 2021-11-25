package carracing;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final StringBuilder builder = new StringBuilder();

    public static void printRounds(List<Round> rounds) {
        rounds.forEach(round -> {
            printRound(round);
            System.out.println();
        });
    }

    private static void printRound(Round round) {
        round.getSteps().forEach((carName, step) -> {
            System.out.printf("%s : %s%n", carName.getName(), stepLine(step));
        });
    }

    private static String stepLine(int step) {
        cleanStringBuilder();
        for (int i = 0; i < step; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    public static void printWinner(List<CarName> winnerCarNames) {
        List<String> winnerNames = winnerCarNames.stream()
                .map(CarName::getName)
                .collect(Collectors.toList());
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    private static void cleanStringBuilder() {
        builder.delete(0, builder.length());
    }
}
