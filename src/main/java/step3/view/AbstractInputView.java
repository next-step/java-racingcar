package step3.view;

import step3.game.CarName;
import step3.game.PositiveNumber;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractInputView implements InputView {

    public static final String NAME_INPUT_DELIMITER = ",";

    @Override
    public PositiveNumber carCount() {
        System.out.println("자동차 대수는 몇 대 인가요?");
        return new PositiveNumber(this.read());
    }

    @Override
    public PositiveNumber tryCount() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return new PositiveNumber(this.read());
    }

    @Override
    public Set<CarName> carNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return parseCarNames(this.read());
    }

    private Set<CarName> parseCarNames(String input) {
        String[] names = input.split(NAME_INPUT_DELIMITER);

        Set<CarName> carNames = new HashSet<>();
        for (String name : names) {
            carNames.add(new CarName(name.trim()));
        }
        return carNames;
    }
}