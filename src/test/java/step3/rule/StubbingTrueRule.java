package step3.rule;

import step3.gameobject.rule.RaceRule;

public class StubbingTrueRule implements RaceRule {

    @Override
    public boolean isMoved() {
        return true;
    }

}
