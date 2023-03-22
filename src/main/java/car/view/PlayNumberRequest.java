package car.view;

import java.util.Scanner;

public class PlayNumberRequest {

    private final int number;

    public PlayNumberRequest(int number) {
        this.number = number;
    }

    public static PlayNumberRequest playNumberRequest() {
        int number = new InputView().playNumberScanner();
        return new PlayNumberRequest(number);
    }

    public int getNumber() {
        return number;
    }
}
