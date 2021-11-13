package study.step3;

import java.util.Random;

/**
 * 차량 클래스
 */
public class Car {
    private static String BLANK_STRING_VALUE = "";
    private static String MOVE_CHARACTER = "-";
    private static int MAX_RANDOM_NUMBER = 10;
    private static int MIN_FORWARD_NUMBER = 4;
    private static int START_LOCATION = 0;

    // 차량 번호
    private int number;
    // 차량 위치
    private int location;

    /**
     * 생성자
     * @param number 차량 번호
     * @param location 차량 위치
     */
    public Car(int number, int location) {
        this.number = number;
        this.location = location;
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
            this.location += MOVE_CHARACTER.length();
        }
    }

    /**
     * 차량 위치 조회
     * @return
     */
    public String getLocation(){
        String position = BLANK_STRING_VALUE;
        for(int i = START_LOCATION; i < this.location; i++){
            position += MOVE_CHARACTER;
        }
        return position;
    }
}
