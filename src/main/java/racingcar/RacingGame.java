package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private int cars, count;

    // 몇대의 차, 몇번의 이동 초기화
    public RacingGame(int cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    // n개 만큼 Car 클래스 생성하기
    public List<Car> settingCars(int cars) {

        ArrayList<Car> list = new ArrayList<>();

        for (int i = 0; i < cars; i++) {
            Car car = new Car();
            list.add(car);
        }

        return list;
    }

    // n번만큼 이동하기
    public void moveToN(List<Car> carList, int count) {
        for (int i = 0; i < count; i++) {
            carStatus(carList);
            System.out.println("");
        }
    }

    // n개의 차의 대한 상태 출력
    public void carStatus(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            carList.get(i).setLocation(isGo(random()));
            new ResultView().result(carList.get(i).getLocation());
        }
    }

    // 전진하기
    private String moveForward() {
        return "-";
    }

    // 앞으로 가는 조건
    public String isGo(int number) {
        if (number >= 4) return moveForward();
        return "";
    }

    // 랜덤함수 출력
    public int random() {

        Random random = new Random();
        int value = random.nextInt(10);

        return value;
    }
}
