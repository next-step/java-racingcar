package camp.nextstep.edu.racingcar.view;

import java.util.Scanner;

public class RacingInputView {

    private static final Scanner sc = new Scanner(System.in);

    public int readCarAmount(){
        return sc.nextInt();
    }

    public int readRoundAmount() {
        return sc.nextInt();
    }
}
