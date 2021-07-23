package racing;

import java.util.List;

import static java.util.stream.IntStream.range;

class Racers {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String DISPLAY_MARK = "-";

    private final List<String> cars;

    private Racers(List<String> cars) {
        this.cars = cars;
    }

    public static Racers from(List<String> cars) {
        return new Racers(cars);
    }

    public int size() {
        return this.cars.size();
    }

    public String get(int index) {
        return cars.get(index);
    }

    public void turnAround(ForwardConditionStrategy strategy, StringBuilder sb) {
        range(0, size()).forEach(index -> turnAround(strategy, sb, index));
    }

    private void turnAround(ForwardConditionStrategy strategy, StringBuilder stringBuilder, int index) {
        if (strategy.judgeCondition()) {
            stringBuilder.append(get(index)).append(NEW_LINE);
            return;
        }
        cars.set(index, cars.get(index) + DISPLAY_MARK);
        stringBuilder.append(get(index)).append(NEW_LINE);
    }
}
