package step3.service;

import step3.util.Validator;

/**
 * Created By mand2 on 2020-11-07.
 */
public class ScoreInspector {
    public static int judgeMovable(int score) {
        Validator.checkArgumentInRange(score, 0, 9);

        return score >= 4 ? 1 : 0;
    }

}
