package step3.rule;

import step3.gameobject.rule.RaceRule;

public class FirstRacerWinRule implements RaceRule {
    boolean isFirstRacer = true;

    @Override
    public boolean race() {
        if (isFirstRacer) {
            isFirstRacer = false;
            return true;
        }
        return false;
    }
}