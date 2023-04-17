package step3;

public class SimpleRacingCar {

    public static void main(String[] args) {

        //몇 대의 자동차로 몇 번의 이동을 할 것인지 사용자 입력받기
        System.out.println("자동차 대수는 몇 대 인가요?");
        int carCnt = InputView.inputInfo();

        System.out.println("시도할 회수는 몇 회 인가요?");
        int repeatCnt = InputView.inputInfo();
    }
}
