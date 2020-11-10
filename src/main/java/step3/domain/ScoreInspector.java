package step3.domain;

import step3.util.Validator;

/**
 * Created By mand2 on 2020-11-07.
 */
public class ScoreInspector {

    private static final int JUDGE_NUMBER = 4;

    public ScoreInspector() {}

    public static int judgeMovable(int score) {
        Validator.checkArgumentInRange(score, 0, 9);

        return score >= JUDGE_NUMBER ? 1 : 0;
    }

    public static int judgeMovable(Randomize randomize) {
        int score = randomize.random();
        Validator.checkArgumentInRange(score, 0, 9);

        return score >= JUDGE_NUMBER ? 1 : 0;
    }

}
