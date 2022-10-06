package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import racing_game.core.Parsable;

public class InputView<T extends Parsable<T>> {

    private final BufferedReader reader;

    public InputView(BufferedReader reader) {
        this.reader = reader;
    }

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public T fromInput(String ment, T target) throws IOException {
        String input = request(ment);
        while (!target.canParse(input)) {
            wrongAlert();
            input = request(ment);
        }
        return target.parse(input);
    }

    private String request(String ment) throws IOException {
        System.out.println(ment);
        return reader.readLine();
    }

    private void wrongAlert() {
        System.out.println("잘못된 입력입니다.");
    }
}
