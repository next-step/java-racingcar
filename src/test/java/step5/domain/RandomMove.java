package step5.domain;


import step5.utils.RandomGenerator;

public class RandomMove extends RandomGenerator {

    private int stack;

    @Override
    public int getRandomNum() {
        stack++;

        if (stack == 1 || stack == 3)
            return 4;
        return 3;
    }
}
