package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing_game.core.Positive;

public class InputView {

    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Positive getInput(String ment) throws IOException {
        String input = request(ment);
        while (!Positive.canParse(input)) {
            System.out.println("잘못된 입력입니다.");
            input = request(ment);
        }
        return Positive.of(input);
    }

    private String request(String ment) throws IOException {
        System.out.println(ment);
        return reader.readLine();
    }

}
