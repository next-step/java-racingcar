package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class InputRacingPlayer extends InputView {

    private static final String CAR_NAME_PATTERN = "^[a-zA-Z0-9가-힣,]*$";

    private static final String CAR_NAME_REGEX = ",";

    private static final String PLAYER_INPUT_VIEW_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static final String PLAYER_INPUT_WARNING_MESSAGE = "자동차 이름은 영문 or 숫자 or 한글과 ','로 을 입력하세요.";

    private static final String PLAYER_NAME_WARNING_MESSAGE = "자동차 이름을 입력하세요.";


    public InputRacingPlayer() {
        super();
    }

    /**
     * 경주 할 자동차 이름 입력 기능
     *
     * @return
     */
    public List<Car> getCarPlayer() {
        super.viewMessage(PLAYER_INPUT_VIEW_MESSAGE);

        String[] carNames = getPlayerNames();

        List<Car> carEntry = new ArrayList<>(carNames.length);

        for (String car : carNames) {
            carEntry.add(Car.create(car));
        }

        return carEntry;
    }

    public String[] getPlayerNames() {

        String input = Optional.ofNullable(super.getScanner().nextLine()).orElseThrow(() -> new IllegalArgumentException(PLAYER_NAME_WARNING_MESSAGE));

        validateInputString(input);

        return setCarNames(input);
    }

    public String[] setCarNames(String input) {

        String[] carNames = input.split(CAR_NAME_REGEX);

        if (carNames.length == 0 || carNames == null) {
            throw new IllegalArgumentException(PLAYER_INPUT_WARNING_MESSAGE);
        }

        return carNames;
    }

    public void validateInputString(String input) {

        boolean regex = Pattern.matches(CAR_NAME_PATTERN, input);

        if (!regex) {
            throw new IllegalArgumentException(PLAYER_INPUT_WARNING_MESSAGE);
        }
    }

    public static InputRacingPlayer createInstance() {
        return new InputRacingPlayer();
    }
}
