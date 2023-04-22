package carracing.present;

import carracing.model.RacingDisplayVO;

public class OutputPresent {
    public void printResult(RacingDisplayVO racingDisplayVO) {
        for (int i = 0; i<racingDisplayVO.iterationCount() ; i++) {

            for (int j=0 ; j<racingDisplayVO.participateCount() ; j++ ) {
                String s = racingDisplayVO.getRecord(i, j);
                System.out.print(racingDisplayVO.participateName(j));
                System.out.println(s);
            }
        }
    }

    public void printWinner(RacingDisplayVO racingDisplayVO) {
        System.out.printf("우승자는 %s 입니다", racingDisplayVO.totalParticipateNames());
    }


}
