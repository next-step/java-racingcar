package step3.strategy.draw;

import java.util.stream.IntStream;

public class DashDrawStrategy implements DrawStrategy {

    private static final String MOVE_PRINT_STRING = "-";
    private static final int INITIAL_INDEX = 0;

    private final StringBuffer stringBuffer = new StringBuffer();

    private DashDrawStrategy() {
    }

    private static class DashDrawStrategyInstanceHolder {
        private static final DashDrawStrategy INSTANCE = new DashDrawStrategy();
    }

    public static DashDrawStrategy getInstance() {
        return DashDrawStrategyInstanceHolder.INSTANCE;
    }

    @Override
    public String draw(int currentLocation) {
        clear();

        IntStream.range(INITIAL_INDEX, currentLocation)
                .mapToObj(carPosition -> MOVE_PRINT_STRING)
                .forEach(stringBuffer::append);

        return stringBuffer.toString();
    }

    @Override
    public void clear() {
        stringBuffer.delete(INITIAL_INDEX, stringBuffer.length());
    }
}
