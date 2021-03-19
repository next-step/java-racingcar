package step3.domain;

import step3.service.GameRule;

public class Car {
    // private String score = "";
    private Score score;

    public Score getScore() {
        return score;
    }

    public void move(GameRule rule) {
        if (rule.isMovable()) {
            // score += "-";
            score.setScore();
        }
    }

    public void moveTest(GameRule rule, int num) {
        if (rule.isMovableTest(num)) {
            // score += "-";
            score.setScore();
        }
    }
}
