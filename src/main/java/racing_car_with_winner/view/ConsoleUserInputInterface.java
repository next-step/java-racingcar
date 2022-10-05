package racing_car_with_winner.view;

import java.util.Scanner;

public class ConsoleUserInputInterface implements UserInputInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void show(String message) {
        System.out.print(message);
    }

    @Override
    public String getStringInput() {
        return scanner.nextLine();
    }
}
