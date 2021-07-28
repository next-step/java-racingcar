package racing.view;

import racing.domain.dto.GameRequest;

public class FakeDosInputView implements InputView {
    private final String carNames;
    private final int turnSize;

    public FakeDosInputView(String carNames, int turnSize) {
        this.carNames = carNames;
        this.turnSize = turnSize;
    }

    @Override
    public GameRequest inputGameRequest() {
        return new GameRequest(carNames, turnSize);
    }
}