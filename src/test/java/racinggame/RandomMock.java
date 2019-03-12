package racinggame;

import java.util.Random;

public class RandomMock extends Random {

    int designatedIntValue;

    public void setDesignatedIntValue(int designatedIntValue) {
        this.designatedIntValue = designatedIntValue;
    }

    @Override
    public int nextInt(int bound) {
        return designatedIntValue;
    }
}