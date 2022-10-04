package racing_car_with_winner.view;

import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public String getStringInput() {
        return scanner.nextLine();
    }
}
