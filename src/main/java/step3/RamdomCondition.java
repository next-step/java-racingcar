package step3;

import java.util.Random;

public class RamdomCondition implements ConditionInterface{
    //삭제 예정 (-> racingCar)
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int ADVANCE_CONDITION = 4;

    //삭제 예정 (-> racingCar)
    //private Random ramdom;

    //삭제예정
    private int RandomValue;

    // 삭제 예정
    // racing car가 랜덤 숫자를 생성함으로 제거함
    private RandomValue randomValue;

    //삭제예정
    public RamdomCondition() {
    //   this.ramdom = new Random();
    }

    //삭제예정
    public RamdomCondition(int RandomValue) {
        this.RandomValue = RandomValue;
    }

    //삭제예정
    public RamdomCondition(RandomValue randomValue) {
        this.randomValue = randomValue;
    }

    // 삭제 예정
    public boolean meet(int compare) {
        return true;
       //return ramdom.nextInt(RANDOM_NUMBER_BOUND) > compare;
    }

    public boolean meet(RandomValue randomValue) {
        return true;
        // RandomValue가 자체 값을 가지고 있으니 여기에서 실제 적용 여부 판단이 불가능 -> 위임해야 함
        //return ramdom.nextInt(RANDOM_NUMBER_BOUND) > compare;
    }

    // 삭제 예정
    // racing car가 랜덤 숫자를 생성함으로 제거함
    public boolean meet() {
        //return this.ramdom.
        return this.randomValue.meet(ADVANCE_CONDITION);
    }


}
