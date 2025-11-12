package racinggame.car;

public class Car {
    private int position;

    private Car() {
        this.position = 1;
    }

    public static Car of() {
        return new Car();
    }

    public void changePosition(int randomNum) {
        if (isKeep(randomNum)) {
            return;
        }

        this.position++;
    }

    // View 쪽 영역에 작성하려다 Car내부에 작성했습니다. 사유는
    // 1. Car 관련 position 값이 외부에 노출되는것 보단 내부에서 값을 확인후 결과값을 돌려주는게 나은 방향인것으로 생각
    // 2. 차 이름이 추가되고 출력 메세지가 차 이름 : --- 이런식으로의 요구사항 변경 고려
    // 3. UI쪽 성격이 짙은 로직을 내부에 두는게 맞나 고민했지만 일종의 toString과 비슷한 성격으로 생각해 내부에 구현
    public String getPositionMark() {
        return "-".repeat(position);
    }

    private boolean isKeep(int randomNum) {
        return randomNum < 4;
    }

    public int getPosition() {
        return position;
    }
}
