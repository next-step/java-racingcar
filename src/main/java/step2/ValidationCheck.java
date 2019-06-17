package step2;

public class ValidationCheck {

    public void checkInputZero(int carQty, int tryCnt){
        if(carQty == 0){
            throw new IllegalArgumentException("경주에 출전하는 차량이 없습니다. 재입력해주세요.");
        }

        if(tryCnt == 0){
            throw new IllegalArgumentException("경주 시도횟수가 0회이므로 게임을 시작할 수 없습니다. 재입력해주세요.");
        }

    }

}
