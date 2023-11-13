package domain;

public class NumberGenerator {

    private RacingRandomNumber randomNumber;

    public NumberGenerator(RacingRandomNumber number) {
        this.randomNumber = number;
    }

    public Integer moveCondition() {
        return randomNumber.number();
    }


}
