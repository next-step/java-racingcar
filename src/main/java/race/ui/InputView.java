package race.ui;

import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getPlayCount() {
        return SCANNER.nextInt();
    }

    // TODO: 2022/11/06 6자 미만으로 입력할 수 있게 처리한다.  
    public static String[] getCarName() {
        return SCANNER.nextLine().split(",");
    }
}
