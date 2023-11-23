package step4.racing;

import java.util.Random;

public class AdvanceprobabilitySixtyPercentReferee implements Referee {

    @Override
    public boolean judgeToMove() {
        Random random = new Random();
        random.nextInt(10);
        return random.nextInt(10) > STANDARD_NUMBER_TO_JUDGE_TO_MOVE;
    }

}
