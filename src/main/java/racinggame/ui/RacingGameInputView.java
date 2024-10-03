package racinggame.ui;

import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameInputView {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MIN_ROUND_COUNT = 1;

    private final MessageReader reader;
    private final MessageWriter writer;

    public RacingGameInputView(final MessageReader reader, final MessageWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public RacingCars inputRacingCarNames() {
        writer.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        final String inputString = reader.readString();
        if (inputString.isEmpty()) {
            throw new IllegalArgumentException();
        }

        final String[] split = inputString.split(",");
        if (split.length < 2) {
            throw new IllegalArgumentException();
        }

        for (final String carName : split) {
            if (carName.isEmpty() || carName.length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        final List<RacingCar> collect = Arrays.stream(split)
            .map(s -> new RacingCar(new RacingGameRandomNumberGenerator()))
            .collect(Collectors.toList());

        return new RacingCars(collect);
    }

    public int inputRacingCarCount() {
        return 0;
    }

    public int inputRacingRoundCount() {
        return 0;
    }
}
