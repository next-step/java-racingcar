package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private int time;
    private List<Integer> carPositions = new ArrayList<>();


    public List<Integer> getCarPositions() {
        return carPositions;
    }

    private void setCars(int cars) {
        for (int car = 0; car < cars; car++) {
            this.carPositions.add(1);
        }
    }

    public int getTime() {
        return time;
    }

    private void setTime(int time) {
        this.time = time;
    }

    public void setGame(int cars, int time) {
        System.out.println("게임을 시작하지.....");
        setCars(cars);
        setTime(time);
    }

    // 이 함수는 private이 맞는 것 같은데.. 테스트 코드 작성을 위해
    // public으로 하는게 맞을까요??
    public int createNewPosition() {
        return new Random().nextInt(10);
    }

    // 요 함수도요...
    public int move(int position) {
        int newPosition = createNewPosition();
        if(newPosition < 4) {
            return position;
        }
        return position + newPosition;
    }

    public void playRound() {
        for (int index=0; index < carPositions.size(); index++) {
            int newPosition = move(carPositions.get(index));
            carPositions.set(index, newPosition);
            printResult(newPosition);
        }
        System.out.println("");
    }

    public void play() {
        for(int round=0; round < time; round ++) {
            playRound();
        }
    }

    public void printResult(int position) {
        for(int dash=0; dash< position; dash++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
