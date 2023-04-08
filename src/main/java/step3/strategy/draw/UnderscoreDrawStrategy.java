package step3.strategy.draw;

import step3.domain.Position;

import java.util.stream.IntStream;

public class UnderscoreDrawStrategy implements DrawStrategy {

    private static final String MOVE_PRINT_STRING = "-";
    private static final int INITIAL_INDEX = 0;

    private final StringBuffer stringBuffer = new StringBuffer();

    private UnderscoreDrawStrategy(){}

    private static class UnderscoreDrawStrategyInstanceHolder{
        private static final UnderscoreDrawStrategy INSTANCE = new UnderscoreDrawStrategy();
    }

    public UnderscoreDrawStrategy getInstance(){
        return UnderscoreDrawStrategyInstanceHolder.INSTANCE;
    }

    @Override
    public String draw(Position position) {
        clear();

        IntStream.range(INITIAL_INDEX, position.getPosition())
                .mapToObj(carPosition -> MOVE_PRINT_STRING)
                .forEach(stringBuffer::append);

        return stringBuffer.toString();
    }

    @Override
    public void clear() {
        stringBuffer.delete(INITIAL_INDEX, stringBuffer.length());
    }
}
