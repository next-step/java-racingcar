package racingcar.domain;

public class MoveCommand {

    private final Number number;
    private final int FORWARD_NUMBER = 4;
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 0;

    public MoveCommand(Number number) {
        this.number = number;
    }

    public MoveType command() {
        int generatedNumber = number.generate();
        assertValidNumberRange(generatedNumber);

        if (generatedNumber >= FORWARD_NUMBER && generatedNumber <= MAX_NUMBER) {
            return MoveType.FORWARD;
        }
        if (generatedNumber >= MIN_NUMBER && generatedNumber < FORWARD_NUMBER) {
            return MoveType.STOP;
        }

        throw new IllegalArgumentException("MoveType을 찾지 못했습니다.");
    }

    private void assertValidNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d~%d 사이의 숫자만 가능합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }
}
