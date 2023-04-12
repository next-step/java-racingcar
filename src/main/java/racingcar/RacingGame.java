package racingcar;


import java.util.Scanner;

public class RacingGame implements InputView {

    @Override
    public int getIntegerInput() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }
}
