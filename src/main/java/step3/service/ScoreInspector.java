package step3.service;

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

}
