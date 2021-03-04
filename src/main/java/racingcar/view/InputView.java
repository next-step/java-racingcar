package racingcar.view;

import racingcar.dto.RacingCarGameRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public RacingCarGameRequest getUserInput() throws IOException {
        int carNumber = getParticipatingCarNumber();
        int playCount = getPlayingCount();
        return new RacingCarGameRequest(playCount, carNumber);
    }

    private int getParticipatingCarNumber() throws IOException {
        while (true) {
            System.out.println(Message.INPUT_CAR_NUMBER.getDescription());
            String carNumberInString = br.readLine().trim();
            try {
                return Integer.parseInt(carNumberInString);
            } catch (NumberFormatException ex) {
                System.out.println(Message.WRONG_INPUT.getDescription());
            }
        }
    }

    private int getPlayingCount() throws IOException {
        while (true) {
            System.out.println(Message.INPUT_PLAY_COUNT.getDescription());
            String countInString = br.readLine().trim();
            try {
                return Integer.parseInt(countInString);
            } catch (NumberFormatException ex) {
                System.out.println(Message.WRONG_INPUT.getDescription());
            }
        }
    }
}
