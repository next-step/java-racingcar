package racing;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Race race = new Race(new InputView(scanner));
        race.start();
    }
}
