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
     * 차량 이동을 위한 시도 숫자 조회
     * @return
     */
    public int tryMoveNumber() {
        Random random = new Random();
        int num = random.nextInt(MAX_RANDOM_NUMBER);
        return num;
    }

    /**
     * 차량 이동
     * @return
     */
    public void moveCar(int tryMoveNumber){
        if(tryMoveNumber >= MIN_FORWARD_NUMBER){
            this.position = this.position + MOVE_CHARACTER;
        }
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
}
