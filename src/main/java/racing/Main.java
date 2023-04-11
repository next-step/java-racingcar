package racing;

public class Main {
    public static void main(String[] args) {
        //자동차 경주 시작 메인
        Racing racing = Racing.start();
        System.out.println("자동차 대수 : "+racing.car_count);
        System.out.println("시도 횟수 : "+racing.try_count);
    }
}
