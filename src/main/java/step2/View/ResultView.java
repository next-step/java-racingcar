/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2.View;

import step2.Dao.ResultData;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String END_OF_WINNER_ANNOUNCE = "가 최종 우승했습니다.";

    public static void show(ResultData resultData, int turn) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int game = 0; game < turn; game++) {
            resultData.drawByTurn(game);
        }
        System.out.print(resultData.getMax());
        System.out.println(END_OF_WINNER_ANNOUNCE);
    }
}
