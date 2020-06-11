package step4.mock;

import step4.model.Fuel;

public class MockFuel implements Fuel {

    @Override
    public boolean isValid() {
        return true;
    }
}
