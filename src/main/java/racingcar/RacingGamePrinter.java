package racingcar;

import java.util.List;

public class RacingGamePrinter {

    public static void printEachCarStatus(String name, int status) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(":");
        for (int j = 0; j < status; j++) {
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    public static void printWinners(List<String> winners) {
        System.out.print("최종 우승자: ");
        String result = String.join(", ", winners);
        System.out.println(result+"\n");
    }
}
