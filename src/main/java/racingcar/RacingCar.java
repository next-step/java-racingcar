package racingcar;

import java.util.List;
import java.util.Random;

// 자동차의 움직임을 관여한다.
public class MoveCar {

    // n번만큼 이동하기
    public void moveToN(List<Car> carList, int count) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).setLocation(isGo(random()));
            System.out.println("");
        }
    }

    // 전진하기
    private String moveForward() {
        return "-";
    }

    // 멈춤
    private String stop() {
        return "";
    }

    // 앞으로 가는 조건
    public String isGo(int number) {
        if (number >= 4) return moveForward();
        return stop();
    }

    // 랜덤함수 출력
    public int random() {
        Random random = new Random();
        int value = random.nextInt(10);

        return value;
    }
}
