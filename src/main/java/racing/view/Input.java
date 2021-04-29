package racing.view;

import java.util.Scanner;

public class Input {
    public String makeCars() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int count() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
