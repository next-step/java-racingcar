package camp.nextstep.edu.racingcar.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingInputViewImpl implements RacingInputView {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int readCarAmount(){
        return readInt();
    }

    @Override
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
