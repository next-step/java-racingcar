/*
 * ResultView.java  1.0.0   2019.10.27
 */
package step2.view;

import step2.dto.ResultData;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 자동차 게임 그래프 출력 부분
 *
 * @author naheenosaur
 * @version 1.0.0
 */
public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String DELIMITER = ", ";
    private static final String MODEL_AND_SCORE_FORMAT = "%s : %s";
    private static final String CAR_LOG_SYMBOL = "-";
    private static final String END_OF_WINNER_ANNOUNCE = "가 최종 우승했습니다.";

    public static void drawGraph(ResultData resultData, int turn) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        for (int game = 0; game < turn; game++) {

            Map<String, Integer> modelAndScoreByTurn = resultData.modelAndScoreByTurn(game);
            drawGraph(modelAndScoreByTurn);
        }
    }

    private static void drawGraph(Map<String, Integer> modelAndScoreByTurn) {
        //todo 그래프 그리기
        System.out.println();
        modelAndScoreByTurn.forEach((model, score) -> {
            String graph = String.join("", Collections.nCopies(score, CAR_LOG_SYMBOL));
            System.out.println(String.format(MODEL_AND_SCORE_FORMAT, model, graph));
        });
    }


    public static void announceWinner(ResultData resultData) {
        List<String> winners = resultData.getWinners();
        StringBuilder winner = new StringBuilder();
        winner.append(winners.get(0));
        for (int index = 1; index < winners.size(); index++) {
            winner.append(DELIMITER);
            winner.append(winners.get(index));
        }
        System.out.println(winner.toString());
        System.out.println(END_OF_WINNER_ANNOUNCE);
    }
}
