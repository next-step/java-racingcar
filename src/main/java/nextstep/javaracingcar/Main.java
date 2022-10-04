package nextstep.javaracingcar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final CarRacingGameConsoleLauncher launcher =
                new CarRacingGameConsoleLauncher(scanner::nextLine, (System.out::println));
        launcher.run();
    }
}
