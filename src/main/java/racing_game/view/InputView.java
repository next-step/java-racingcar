package racing_game.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing_game.core.Positive;
import racing_game.domain.CarName;

public class InputView {

    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Positive getPositive(String ment) throws IOException {
        String input = request(ment);
        while (!Positive.canParse(input)) {
            alertWrong();
            input = request(ment);
        }
        return Positive.of(input);
    }

    public List<CarName> getCarNames(String ment) {
        try {
            String input = request(ment);
            return Arrays.stream(input.split(","))
                .map(CarName::new)
                .collect(Collectors.toList());
        } catch (Exception e) {
            alertWrong();
            return getCarNames(ment);
        }
    }

    private String request(String ment) throws IOException {
        System.out.println(ment);
        return reader.readLine();
    }

    private void alertWrong() {
        System.out.println("잘못된 입력입니다.");
    }

}
