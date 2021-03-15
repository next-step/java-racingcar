package step3.study.domain;


import step3.study.util.Validator;

public class Round {
    private final int round;

    public Round(String round) {
        this.round = Validator.numberCheck(round);
        if(this.round <= 0 ){
           throw new IllegalArgumentException("시행 횟수는 0회 이상이어야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
