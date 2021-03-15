package step3.study.view;

import step3.study.dto.ResponseRacingDTO;

import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println("실행결과");
    }

    public void printRacingGameResult(ResponseRacingDTO responseRacingDTO) {
        printDistance(responseRacingDTO);
    }

    private void printDistance(ResponseRacingDTO responseRacingDTO) {
        List<String> nameAndNowPositions = responseRacingDTO.getNameAndNowPosition();
        for (String nameAndNowPosition : nameAndNowPositions) {
            System.out.println(nameAndNowPosition);
        }
        System.out.println();
    }

    public void printRacingGameWinners(List<String> winnerNameList) {
        String winnerNames = String.join(", ", winnerNameList);
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
