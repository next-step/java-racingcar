package racing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class RacingUI {

    public static void printRacing(Cars cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            printRound(cars, i);
        }
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종우승자: " + String.join(", ", winners));
    }

    private static void printRound(Cars cars, int roundNumber) {
        for (int j = 0; j < cars.getCarsSize(); j++) {
            printCarDistance(cars.getName(j), cars.getRoundDistance(j, roundNumber));
        }
        System.out.println();
    }

    private static void printCarDistance(String name, int dist) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dist; i++) {
            sb.append('-');
        }
        System.out.println(name + " : " + sb);
    }

    public static String[] readCarName() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        String[] names = br.readLine().split(",");
        return names;
    }

    public static int readRoundNumber() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(br.readLine());
    }
}
