package racing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Race race = new Race(new InputView(new Scanner(System.in)));
        race.start();
    }
}
