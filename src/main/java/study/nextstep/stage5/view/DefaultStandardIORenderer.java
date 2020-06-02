package study.nextstep.stage5.view;

import study.nextstep.stage5.domain.GameStatus;

public class DefaultStandardIORenderer implements Renderer {
    private static final String POSITION_RENDER_CHARACTER = "-";

    @Override
    public void render(String[] names, GameStatus status) {
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%s : %s%n", names[i],
                    POSITION_RENDER_CHARACTER.repeat(status.getPosition(i).getValue()));
        }
        System.out.println();
    }

    @Override
    public void renderFirstStatus(GameStatus status) {
        System.out.println("실행 결과");
    }

    @Override
    public void renderWinner(String[] names, GameStatus status) {
        String winnerNames = status.getWinnerNames(names);
        System.out.printf("%s가 최종 우승했습니다.", winnerNames);
    }
}
