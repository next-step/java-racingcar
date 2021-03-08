package step3;

import java.util.Random;

public class RacingCar {

    public RacingCar() {}

    void start() {
        InputView inputView = new InputView();
        int car = inputView.getInput()[0];
        int trial = inputView.getInput()[1];

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
