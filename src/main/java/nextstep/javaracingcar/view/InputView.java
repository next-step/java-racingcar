package nextstep.javaracingcar.view;

import nextstep.javaracingcar.domain.CarRacingGameInput;

public class InputView {

    private final InputSupplier inputSupplier;
    private final OutputConsumer outputConsumer;

    public InputView(final InputSupplier inputSupplier, final OutputConsumer outputConsumer) {
        this.inputSupplier = inputSupplier;
        this.outputConsumer = outputConsumer;
    }

    public CarRacingGameInput input() {
        outputConsumer.write("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String carNames = inputSupplier.read();

        outputConsumer.write("시도할 횟수는 몇 회 인가요?");
        final String round = inputSupplier.read();

        return new CarRacingGameInput(carNames, Integer.parseInt(round));
    }
}
