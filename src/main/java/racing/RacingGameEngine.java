package racing;

import racing.ui.RacingGameInput;
import racing.ui.RacingGameRenderer;

/**
 * 레이싱 게임을 구동하는 게임 엔진
 */
public class RacingGameEngine {
    private RacingGameState gameState;

    /**
     * 게임의 초기화 phase.
     * play전에 게임 상태를 미리 세팅할 것이 있다면
     * 여기서 진행됩니다.
     */
    public void init() {
        int theNumberOfCar = RacingGameInput.askTheNumberOfCar();
        int theNumberOfCycle = RacingGameInput.askTheNumberOfCycle();

        gameState = RacingGameLogic.init(theNumberOfCar, theNumberOfCycle);
    }

    /**
     * 게임을 실행합니다. 게임은 로직에 의해 종료될 때까지 자동 반복됩니다.
     * 업데이트 -> 렌더링이 하나의 틱이며 틱이 계속 반복됩니다.
     */
    public void play() {
        while (!RacingGameLogic.isGameOver(gameState)) {
            gameState = RacingGameLogic.update(gameState);
            RacingGameRenderer.renderGame(gameState);
        }
    }
}
