package carracing.service.dto;

import carracing.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Players
 * description 경기에 참가한 차량 리스트
 * version 0.0.1
 *
 * history
 *  0.0.1) 클래스 신규생성
 */
public class Players {

    List<Car> playerList = new ArrayList<>();

    public List<Car> getCarList() {
        return playerList;
    }

    public void registerPlayer(Car car) {
        validate(car);
        this.playerList.add(car);
    }

    private void validate(Car car) {
        if(car==null) {
            throw new IllegalArgumentException("차량정보를 입력해 주세요.");
        }
        if(playerList.stream().anyMatch(player -> player.getCarNumber()==car.getCarNumber())) {
            throw new IllegalArgumentException("이미 등록된 차량입니다.");
        }
    }
}
