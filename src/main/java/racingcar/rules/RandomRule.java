package racingcar.rules;

public class RandomRule implements Rule {

    @Override
    public boolean move() {
        int random = (int) (Math.random() * 10);
        return isMove(random);
    }

    private boolean isMove(final int random) {
        return random >= 4 && random < 10;
    }
}
