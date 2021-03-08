package step3;

import java.util.Random;

public class ResultView {

    public ResultView() {}

    public void printResult(int car, int trial) {
        System.out.println("\n실행 결과");
        Random random = new Random();

        while (0 < trial) {
            trial--;

            for (int i = 0; i < car; i++) {
                int number = random.nextInt(10);
                System.out.println(String.format("%" + random.nextInt(10) + "s", "-")
                        .replace(" ", "-"));
            }
            System.out.println();
        }

    }
}
