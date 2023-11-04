package step3;

public class MyRandomValueGenerator implements RandomValueGenerator {

    @Override
    public double generateRandomValue() {
        return Math.random();
    }
}
