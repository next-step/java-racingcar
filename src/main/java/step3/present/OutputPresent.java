package step3.present;

import java.util.List;

public class OutputPresent {
    public void printResult(List<DisplayRaceVO> collect) {
        System.out.println("실행 결과");
        for (int i = 0; i < collect.get(0).getResult().getPositionList().size(); i++) {
            System.out.println();
            for (DisplayRaceVO displayRaceVO : collect) {
                System.out.printf("%s : %s\n", displayRaceVO.getCar().getName(), displayRaceVO.getResult().getDisplayList().get(i));
            }
        }
    }

    public void printWinner(List<String> winnerList) {
        System.out.printf("%s 가 최종 우승하였습니다", String.join(",", winnerList));

    }
}
