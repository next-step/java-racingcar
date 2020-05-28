package game;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class InputRacingPlayer extends InputView {

    private final static String CAR_NAME_PATTERN = "^[a-zA-Z0-9가-힣,]*$";

    private final static String CAR_NAME_REGEX = ",";

    public InputRacingPlayer() {
        super();
    }

    /**
     * 경주 할 자동차 이름 입력 기능
     *
     * @return
     */
    public List<Car> getCarPlayer() {
        super.viewMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        List<Car> carEntry = Car.createCarEntry(getPlayerNames());

        return carEntry;
    }

    public String[] getPlayerNames() {

        String input = Optional.ofNullable(super.getScanner().nextLine()).orElseThrow(() -> new IllegalArgumentException("자동차 이름을 입력하세요."));

        validateInputString(input);

        return setCarNames(input);
    }

    public String[] setCarNames(String input) {

        String[] carNames = input.split(CAR_NAME_REGEX);

        if (carNames.length == 0 || carNames == null) {
            throw new IllegalArgumentException("자동차 이름은 영문 or 숫자 or 한글과 ','로 을 입력하세요.");
        }

        return carNames;
    }

    public void validateInputString(String input) {

        boolean regex = Pattern.matches(CAR_NAME_PATTERN, input);

        if (!regex) {
            throw new IllegalArgumentException("자동차 이름은 영문 or 숫자 or 한글과 ','로 을 입력하세요.");
        }
    }

    public static InputRacingPlayer createInstance() {
        return new InputRacingPlayer();
    }
}
