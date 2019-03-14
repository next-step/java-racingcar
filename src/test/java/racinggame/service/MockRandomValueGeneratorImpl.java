package racinggame.service;

public class MockRandomValueGeneratorImpl implements RandomValueGenerator {

    int designatedIntValue;

    public MockRandomValueGeneratorImpl(int designatedIntValue) {
        this.designatedIntValue = designatedIntValue;
    }

    @Override
    public int getRandomInteger() {
        return designatedIntValue;
    }
}