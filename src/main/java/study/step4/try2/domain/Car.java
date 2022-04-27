package study.step4.try2.domain;

public class Car {
    private final int MOVE_NUMBER = 4; // 매직넘버 상수화

    private final String carName;
    private final Position position;
    private final MoveRecord moveRecord;

    public Car(String carName, Position position) {
        this.carName = carName;
        this.position = position;
        this.moveRecord = new MoveRecord(carName);
    }

    public static Car of(String carName, Position position) {
        return new Car(carName, position);
    }

    public String getCarName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            this.position.increase();
        }
        // 리뷰어님에게 질문하기
        /*
        안녕하세요. 승현리뷰어님,
        자동차 경주게임 미션 수행 중 제 생각이 기존에 구현했던 소스로만 생각이나 리뷰어님의 소스를 참고하게 되었습니다..
        제가 생각하지 못했던 전혀 다른 방법으로 구현하신 거 같아서 해당 생각을 하실 수 있었던 것이 궁금하여 DM드리게 되었습니다.
        racingRecord.save(position); 이렇게 함으로써 기록을 누적을 할 수 있다고 생각하신 이유가 Cars 에 저장된 Car 객체별로 RacingRecord 객체를 가지고 있어서라고 생각하신 것이 맞는지요??
        아직까지 객체지향적으로 생각하는 연습이 부족한 것 같습니다..
        소스를 작성하면서 객체지향적으로 생각하는 것을 빠르게 익숙해지려면 어떻게 해야할까요?..
        감사합니다..!
         */
        this.moveRecord.save(this.position.getPosition());
    }

    public void print(int round) {
        this.moveRecord.print(this.carName, round);
    }
}
