package racingcar.infra;

import racingcar.domain.MoveCommand;
import racingcar.domain.MoveType;

public class MoveCommandImpl implements MoveCommand {

    private final Number number;
    private final int FORWARD_NUMBER = 4;
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 0;

    public MoveCommandImpl(Number number) {
        this.number = number;
    }

    @Override
    public MoveType command() {
        int generatedNumber = number.generate();

        if (generatedNumber >= FORWARD_NUMBER && generatedNumber <= MAX_NUMBER) {
            return MoveType.FORWARD;
        } else if (generatedNumber >= MIN_NUMBER && generatedNumber < FORWARD_NUMBER) {
            return MoveType.STOP;
        }

        throw new IllegalArgumentException(String.format("%d~%d 사이의 숫자만 가능합니다.", MIN_NUMBER, MAX_NUMBER));
    }
}
