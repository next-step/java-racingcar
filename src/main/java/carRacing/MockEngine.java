package carRacing;

public class MockEngine implements Engine{

    private int powerOutput;

    public MockEngine(int powerOutput) {
        this.powerOutput = powerOutput;
    }

    @Override
    public int getPowerOutput() {
        return powerOutput;
    }
}
