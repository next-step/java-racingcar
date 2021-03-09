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
                System.out.println(String.format("%" + results[i] + "s", "-")
                        .replace(" ", "-"));
            }
            System.out.println();
        }

    }
}
