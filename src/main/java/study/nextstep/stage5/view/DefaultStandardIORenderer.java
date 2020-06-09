package study.nextstep.stage5.view;

import study.nextstep.stage5.domain.GameStatus;
import study.nextstep.stage5.domain.Position;

public class DefaultStandardIORenderer implements Renderer {
    private static final String POSITION_RENDER_CHARACTER = "-";

    @Override
    public void render(GameStatus status) {
        for (Position position : status) {
            System.out.println(position.renderPosition(POSITION_RENDER_CHARACTER));
        }
        System.out.println();
    }

    @Override
    public void renderFirstStatus(GameStatus status) {
        System.out.println("실행 결과");
    }

    @Override
    public void renderWinner(String[] names, GameStatus status) {
        String winnerNames = status.getWinnerNames();
        System.out.printf("%s가 최종 우승했습니다.", winnerNames);
    }
}
