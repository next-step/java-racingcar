package racing;

import ui.RacingGameRenderer;

/**
 * 레이싱 게임을 구동하는 게임 엔진
 */
public class RacingGameEngine {
    private RacingGame game;

    private RacingGameEngine() {
    }

    /**
     * 기본 레이싱 게임 로직이 장착된 레이싱 게임 엔진을 생성합니다.
     *
     * @return 레이싱 게임 엔진
     */
    public static RacingGameEngine create() {
        return RacingGameEngine.createWithCustomRacingGame(RacingGame.createRacingGame());
    }

    /**
     * 레이싱 게임을 구동하는 레이싱 게임 엔진을 커스텀 레이싱 게임 로직을 넣어 생성합니다.
     *
     * @param game 레이싱 게임 로직
     *
     * @return 레이싱 게임 엔진
     */
    public static RacingGameEngine createWithCustomRacingGame(RacingGame game) {
        RacingGameEngine gameEngine = new RacingGameEngine();

        gameEngine.game = game;

        return gameEngine;
    }

    public void play() {
        boolean stopFlag = false;

        int theNumberOfCar = RacingGameInput.askTheNumberOfCar();
        int theNumberOfCycle = RacingGameInput.askTheNumberOfCycle();

        game.init(theNumberOfCar, theNumberOfCycle);

        while (!stopFlag) {
            stopFlag = game.update();
            RacingGameRenderer.renderGame(game);
        }
    }
}
