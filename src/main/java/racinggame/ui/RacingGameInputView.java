package racinggame.ui;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racinggame.domain.RacingGameRules.*;

public class RacingGameInputView {
    private final static String DELIMITER = ",";

    private final MessageReader reader;
    private final MessageWriter writer;

    public RacingGameInputView(final MessageReader reader, final MessageWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public RacingCars inputRacingCarNames() {
        writer.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        final String[] carNames = parseCarNames(reader.readString());
        validateCarNames(carNames);

        return new RacingCars(createRacingCars(carNames));
    }

    private String[] parseCarNames(final String userInput) {
        if (userInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }

        return userInput.split(DELIMITER);
    }

    private void validateCarNames(final String[] carNames) {
        if (carNames.length < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException("최소 2대의 자동차 이름을 입력해야 합니다.");
        }

        for (final String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(final String carName) {
        if (carName.isEmpty() || carName.length() > MAX_RACING_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 최대 " + MAX_RACING_CAR_NAME_LENGTH + "글자를 초과 할 수 없습니다.");
        }
    }

    private List<RacingCar> createRacingCars(final String[] carNames) {
        return Arrays.stream(carNames)
            .map(s -> new RacingCar(new RacingGameRandomNumberGenerator()))
            .collect(Collectors.toList());
    }

    public int inputRacingRoundCount() {
        writer.write("시도할 회수는 몇 회 인가요?");

        final int roundCount = reader.readInt();
        if (roundCount < MIN_RACING_ROUND_COUNT) {
            throw new IllegalArgumentException("시도할 회수는 최소 " + MIN_RACING_ROUND_COUNT + "회 이상이여야 합니다.");
        }

        return roundCount;
    }
}
