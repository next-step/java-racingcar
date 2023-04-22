package step3.present;

import step3.model.Racer;

import java.util.List;

public class OutputPresent {
    public void printResult(List<RacingDisplayVO> racingDisplayVOList) {
         for(RacingDisplayVO racingDisplayVO :racingDisplayVOList) {
             System.out.println(racingDisplayVO.getCarName());
             for(String s : racingDisplayVO.getResults()) {
                 System.out.println(s);
             }
         }
    }

    public void printWinner(List<RacingDisplayVO> racingDisplayVOList) {
        String winners = winnerString(racingDisplayVOList);
        System.out.printf("우승자는 %s 입니다", winners);
    }

    private String winnerString(List<RacingDisplayVO> racingDisplayVOList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(RacingDisplayVO racingDisplayVO : racingDisplayVOList) {
            stringBuilder.append(racingDisplayVO.getCarName());
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}
