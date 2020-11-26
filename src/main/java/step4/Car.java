/*
 * 각 자동차 객체로, 이동 거리를 관리하는 클래스
 * */
package step4;

import java.util.Random;

public class Car {
    private String name;
    private int position;
    private static Random random = new Random();

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    /**
     * 자동차의 위치를 변경하는 메소드로 랜덤값을 인자로 넘기는 메소드
     */
    public void move() {
        this.move(getRandomNumber());
    }

    /**
     * 자동차의 위치를 가져오는 메소드
     * */
    public int getPosition() {
        return this.position;
    }

    /**
     * 자동차 경주자의 이름을 가져오는 메소드
     * */
    public String getName() {
        return this.name;
    }

    /**
     * 자동차의 전진 여부를 검사하여 위치를 변경하는 메소드
     */
    public void move(int num) {
        if (isMovable(num)) {
            this.position++;
        }
    }

    /**
     * 랜덤으로 생성된 숫자가 전진 조건인지 아닌지 판별하는 메소드
     */
    public static boolean isMovable(int number) {
        return number >= Constants.MOVE_CONDITION;
    }

    /**
     * 0에서 9사이의 랜덤값을 생성하는 메소드
     */
    private static int getRandomNumber() {
        return random.nextInt(Constants.RANDOM_RANGE);
    }

}
