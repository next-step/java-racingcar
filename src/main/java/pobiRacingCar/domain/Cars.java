package pobiRacingCar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars; //input cars 외 추가 x final

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinners() {
        return filterWinners(getMaxPosition( ));
    }

    /**
     * getter 대신 객체 메세지, 위임
     * (객체.getXXX() == 어떤 값) : 테스트 힘듦 좌변 2개 우변 1개 검증
     * 반면 그 객체에 위임해서 if () {exception } return norm 2:13
     */


    private List<Car> filterWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            Position position = car.getPosition();
            //if (position.isWinner()) { //position에게 maxPosition 위임 메시지
            if (position.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            Position position = car.getPosition();
            if (maxPosition < position.getPosition()) {
                maxPosition = position.getPosition();
            }
        }
        return maxPosition;
    }
}
