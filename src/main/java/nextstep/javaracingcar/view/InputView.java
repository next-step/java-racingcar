package nextstep.javaracingcar.view;

import nextstep.javaracingcar.CarRacingGameInput;

public class InputView {

    private final InputSupplier inputSupplier;
    private final OutputConsumer outputConsumer;

    public InputView(final InputSupplier inputSupplier, final OutputConsumer outputConsumer) {
        this.inputSupplier = inputSupplier;
        this.outputConsumer = outputConsumer;
    }

    public CarRacingGameInput input() {
        outputConsumer.write("자동차 대수는 몇 대 인가요?");
        final String carCount = inputSupplier.read();

        outputConsumer.write("시도할 횟수는 몇 회 인가요?");
        final String round = inputSupplier.read();

        return new CarRacingGameInput(
                Integer.parseInt(carCount), Integer.parseInt(round)
        );
    }
}
