package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
  //  private final static String MILEAGE_UNIT = "-";
    private String name; // 자동차명
    private String totalMileage; // 전진 시  주행 거래 "-" 하나 추가
    private List<String> moveAndStopStatusHistory ; // 회차 random 숫자 이력

    public Car(String name) {
        this.name = name;
        this.totalMileage = ""; // 주행 총 거리 초기화
        this.moveAndStopStatusHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void run() {
        if (CarMoveUtil.isMove()) {
            move();
            moveAndStopStatusHistory.add(MoveStopStatusEnum.MOVE.getStatus());
            return;
        }
        moveAndStopStatusHistory.add(MoveStopStatusEnum.STOP.getStatus());
    }

    public void move() {
        totalMileage += MoveStopStatusEnum.MOVE.getMoveLength(); // MoveLength는 한번에 이동하는 길이 "-"
    }
    public void stop() {
        totalMileage += "";
    }
    // 특정 회차 이동 거리 조회
    public String getMileageOfNthRun(int nth) {
        String mileage = "";
        if (moveAndStopStatusHistory.isEmpty()) {
            return mileage;
        }
        for (int i = 0; i < nth; i++) {
            mileage += MoveStopStatusEnum.getEnumByStatus(moveAndStopStatusHistory.get(i)).getMoveLength();
        }
        return mileage;
    }


    public String getTotalMileage() {
        return totalMileage;
    }

}
