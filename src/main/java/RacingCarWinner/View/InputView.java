package RacingCarWinner.View;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getIntData(String question) {
        System.out.println(question);
        return scanner.nextInt();
    }

    public String getStringData(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public String[] getSplitStringData(String inputStringData, String regex) {
        return inputStringData.split(regex);
    }
}
