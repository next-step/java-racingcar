package step3.application.generator;

public class NumberPredicatedGenerator implements NumberGenerator {

    private int order;
    @Override
    public int drawNumber() {
        order += 1;
        if (order % 2 == 0) {
            return 0;
        }
        return 5;
    }
}
