package study.nextstep.stage5.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Positions implements Iterable<Position>{
    private List<Position> status;
    private int remainingTotalTurn;

    public Positions(String[] names, int totalTurn) {
        status = new ArrayList<>();
        for (String name : names) {
            status.add(new Position(name));
        }
        remainingTotalTurn = totalTurn;
    }

    public boolean run(Random randomModule) {
        if (remainingTotalTurn <= 0) {
            return false;
        }

        for (Position stat : status) {
            stat.run(randomModule);
        }
        remainingTotalTurn--;
        return true;
    }

    @Override
    public Iterator<Position> iterator() {
        return (Iterator<Position>) status;
    }
}
