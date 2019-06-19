package carRacing.model;

public class MockGamePoint implements GamePoint{


    private int number;

    public MockGamePoint(int number) {
        this.number = number;
    }

    @Override
    public int getGamePoint() {
        return number;
    }
}
