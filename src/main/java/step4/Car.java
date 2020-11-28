/*
 * 각 자동차 객체로, 이동 거리를 관리하는 클래스
 * */
package step4;

public class Car {
    private String name;
    private int position;

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    /**
     * 자동차의 위치를 변경하는 메소드로 랜덤값을 인자로 넘기는 메소드
     */
    public void move() {
        this.move(Util.getRandomNumber());
    }

    /**
     * 자동차의 위치를 가져오는 메소드
     * @return 자동차 객체의 위치
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * 자동차 이름을 가져오는 메소드
     * @return 자동차 객체의 이름
     */
    public String getName() {
        return this.name;
    }

    /**
     * 자동차의 전진 여부를 검사하여 위치를 변경하는 메소드
     * @param num 랜덤으로 생성된 숫자
     */
    public void move(int num) {
        if (isMovable(num)) {
            this.position++;
        }
    }

    /**
     * 랜덤으로 생성된 숫자가 전진 조건인지 아닌지 판별하는 메소드
     * @param number 랜덤으로 생성된 숫자
     * @return 전진 여부
     */
    public static boolean isMovable(int number) {
        return number >= Constants.MOVE_CONDITION;
    }
}
