package racingcar;

import racingcar.strategy.MoveStrategy;
import racingcar.strategy.Printable;

public class RacingCar implements Printable, Comparable<RacingCar> {
    private int position = 0;
    private String name;
    private final MoveStrategy moveStrategy;

    public RacingCar(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void goOrStop() {
        if (moveStrategy.shouldMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String getPrintData() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(position, o.position);
    }
}
