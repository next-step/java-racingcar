package study.step3;

import java.util.Objects;
import java.util.Random;

/**
 * 차량 클래스
 */
public class Car {
    private static String MOVE_CHARACTER = "-";
    private static int MAX_RANDOM_NUMBER = 10;
    private static int MIN_FORWARD_NUMBER = 4;

    // 차량 번호
    private int number;
    // 차량 위치
    private String position;

    /**
     * 생성자
     * @param number 차량 번호
     * @param position 차량 위치
     */
    public Car(int number, String position) {
        this.number = number;
        this.position = position;
    }

    /**
     * 차량 이동
     */
    public void move(){
        Random random = new Random();
        int num = random.nextInt(MAX_RANDOM_NUMBER);
        if(num >= MIN_FORWARD_NUMBER){
            this.position = this.position + MOVE_CHARACTER;
        }
//        System.out.println("Car number : " + this.number + " | random number : "  + num + " | position : "  + position);
    }

    /**
     * 차량 위치 조회
     * @return
     */
    public String getPosition(){
        return this.position;
    }

    /**
     * 차량 정보 문자열 조회
     * @return
     */
    @Override
    public String toString() {
        return "Car{" + "number=" + number + ", position='" + position + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return number == car.number && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
