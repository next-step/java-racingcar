package camp.nextstep.edu.racingcar.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingInputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int readCarAmount(){
        return readInt();
    }

    public int readRoundAmount() {
        return readInt();
    }

    private int readInt() {
        try {
            return Integer.parseInt(br.readLine());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
