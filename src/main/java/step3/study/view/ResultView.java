package step3.study.view;

import step3.study.dto.ResponseRacingDTO;
import step3.study.dto.ResponseWinnerDTO;
import step3.study.util.StringUtils;

import java.util.List;

public class ResultView {
    public ResultView() {
        System.out.println("실행결과");
    }

    public void print(ResponseRacingDTO responseRacingDTO) {
        racingGameResult(responseRacingDTO);
    }

    private void racingGameResult(ResponseRacingDTO responseRacingDTO) {
        List<String> names = responseRacingDTO.getNames();
        List<Integer> positions = responseRacingDTO.getPosition();
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + StringUtils.repeat("-", positions.get(i)));
        }
        System.out.println();
    }

    public void racingGameWinners(ResponseWinnerDTO responseWinnerDTO) {
        List<String> winnerNames = responseWinnerDTO.getWinnerNames();
        String result = String.join(", ", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }
}
