package step3;

import java.util.Random;

public class ResultView {

    public ResultView() {}

    public void printResult(int car, int trial) {
        System.out.println("\n실행 결과");
        Random random = new Random();
        int[] results = new int[car];

        while (0 < trial--) {

            for (int i = 0; i < car; i++) {
                int number = random.nextInt(10);
                results[i] += number;
                String format = results[i] > 0 ? "%" + results[i] + "s" : "%s";
                System.out.println(String.format(format, "-").replace(" ", "-"));
            }
            System.out.println();
        }

    }
}
