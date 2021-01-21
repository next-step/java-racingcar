package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static final int START_POSITION = 0;
    static final int MOVE_THRESHOLD = 4;
    static final int RANDOM_START_INCLUSIVE = 0;
    static final int RANDOM_END_INCLUSIVE = 9;
    private int gameCnt = 0;
    private List<Car> carList;

    public Game(int cnt, List<Car> carList) {
        this.gameCnt = cnt;
        this.carList = carList;
    }

    public void start() {
        System.out.println("\n" + Constant.EXECUTION_RESULT);
        for (int i = 0; i < gameCnt; i++) {
            play();
            print();
        }
        printWinner();
    }

    private void printWinner() {
        System.out.print(Constant.FINAL_WINNER);
        List<String> winnerList = getWinner();
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            if (i != winnerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    private List<String> getWinner() {
        int maxPosition = START_POSITION;
        List<String> winnerList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i++) {
            int tmpPosition = carList.get(i).getPosition();
            maxPosition = Math.max(maxPosition, tmpPosition);
        }

        for (int i = 0; i < carList.size(); i++) {
            if (maxPosition == carList.get(i).getPosition()) {
                winnerList.add(carList.get(i).getName());
            }
        }
        return winnerList;
    }

    private void print() {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).printCarState();
        }
        System.out.println();
    }

    private void play() {
        int[] carRandomNum = new int[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
            carRandomNum[i] = RandomUtils.nextInt(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
            checkMove(i, carRandomNum[i]);
        }
    }

    private void checkMove(int carIdx, int randomNum) {
        if (randomNum >= MOVE_THRESHOLD) {
            carList.get(carIdx).updatePosition();
        }
    }
}
