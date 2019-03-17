package racinggame.Vo;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> carList;      // 자동차들을 저장하는 리스트
    private int countGame;          // 시도할 회수

    // 사용자에게 입력받은 자동차 회수와 game 횟수를 저장하는 생성자
    public Racing(int CountCar, int countGame) {
        carList = new ArrayList<>();

        for(int i = 0; i < CountCar; i++) {
            carList.add(new Car());
        }

        this.countGame = countGame;
    }


    public List<Car> getCarList() {
        return carList;
    }
    public int getCountGame() {
        return countGame;
    }
}
