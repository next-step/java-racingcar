package study.nextstep.stage3;

import java.util.ArrayList;
import java.util.Random;

public class GameStatus {
    private static final int THRESHOLD_CAR_MOVE_RANDOM_VAL = 4;
    private static final int CAR_MOVE_RANDOM_GENERATE_VAL = 10;
    private Random randomModule;
    private ArrayList<Integer> status;
    private int totalGameTurn;
    private int currentGameTurn;

    public GameStatus(int cars, int count, Random randomModule) {
        this.randomModule = randomModule;
        status = new ArrayList<>();
        for(int i = 0; i < cars; i ++ ){
            status.add(1);
        }

        this.totalGameTurn = count;
        this.currentGameTurn = 0;
    }

    public boolean isTurnEnd() {
        return currentGameTurn >= totalGameTurn;
    }

    public void turn() {
        currentGameTurn++;
        if (isTurnEnd()) return;

        for(int i = 0; i < status.size(); i ++ ){
            if (THRESHOLD_CAR_MOVE_RANDOM_VAL <= randomModule.nextInt(CAR_MOVE_RANDOM_GENERATE_VAL)){
                status.set(i, status.get(i) + 1);
            }
        }
    }

    public int size() {
        return status.size();
    }

    public int renderCarPosition(int car) {
        if (car >= size())
            throw new IllegalArgumentException();
        return status.get(car);
    }
}

