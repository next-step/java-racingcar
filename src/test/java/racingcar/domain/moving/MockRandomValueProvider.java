package racingcar.domain.moving;

public class MockRandomValueProvider extends RandomValueProvider {

    private int result;

    public MockRandomValueProvider(int result) {
        super(0);
        this.result = result;
    }

    @Override
    public int get() {
        return result;
    }
}
