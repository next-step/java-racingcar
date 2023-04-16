package basicgame;

public class Car implements Vehicle {
    private final static int CONDITION_VALUE = 4;
    private int distance = 0;

    public void go(int value) {
        if (isEnoughValue(value)) {
            distance++;
        }
    }

    public boolean isEnoughValue(int value) {
        return CONDITION_VALUE <= value;
    }

    @Override
    public String printDistance(String mark) {
        StringBuilder stringBuffer = new StringBuilder();
        for(int i =0; i<distance; i++) {
            stringBuffer.append(mark);
        }
        return stringBuffer.toString();
    }
}
