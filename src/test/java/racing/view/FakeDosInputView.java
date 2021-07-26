package racing.view;

import racing.domain.game.dto.GameRequest;

public class FakeDosInputView implements InputView {
    private String carNames;
    private int turnSize;

    public FakeDosInputView(String carNames, int turnSize) {
        this.carNames = carNames;
        this.turnSize = turnSize;
    }

    @Override
    public GameRequest inputGameRequest() {
        return new GameRequest(carNames, turnSize);
    }
}