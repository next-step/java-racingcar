package racingcar.view;

import java.util.Scanner;

import static racingcar.Constants.*;

public class InputView {

    public void main(String[] args) {
        int carCounts = 0;
        int racingCounts = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println(ASK_CAR_COUNT);
        carCounts = scanner.nextInt();
        System.out.println(ASK_RACING_COUNT);
        racingCounts = scanner.nextInt();
    }

}
