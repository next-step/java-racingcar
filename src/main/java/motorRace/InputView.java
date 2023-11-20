package motorRace;

import java.util.Scanner;

import static motorRace.ResultView.systemOut;

public class InputView {
    public static int systemIn(String msg){
        systemOut(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
