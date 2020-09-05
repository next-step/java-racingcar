package racingcar.view.inputView;

import java.util.Scanner;

public class SystemIn implements InputChannel {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public int getIntValue() {
        try {
            return scanner.nextInt( );
        } finally {
            scanner.nextLine( );
        }
    }

    @Override
    public String getStringValue() {
        return scanner.nextLine( );
    }
}

