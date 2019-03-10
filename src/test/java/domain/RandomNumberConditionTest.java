package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberConditionTest {
    private RandomNumberCondition randomNumberCondition;

    @Test
    public void correct_range() {
        randomNumberCondition = new RandomNumberCondition(0, 9, -1);
        assertThat(randomNumberCondition.canPass()).isTrue();
        randomNumberCondition = new RandomNumberCondition(0, 9, 10);
        assertThat(randomNumberCondition.canPass()).isFalse();
        randomNumberCondition = new RandomNumberCondition(5, 15, 3);
        assertThat(randomNumberCondition.canPass()).isTrue();
        randomNumberCondition = new RandomNumberCondition(5, 15, 16);
        assertThat(randomNumberCondition.canPass()).isFalse();
    }
}
