package racingcar.logic;

public class MockRandomValueProvider extends RandomValueProvider {

    private Integer result;

    MockRandomValueProvider(Integer result) {
        super(0);
        this.result = result;
    }

    @Override
    public Integer get() {
        return result;
    }
}
