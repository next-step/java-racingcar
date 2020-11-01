/*
 * 클래스 이름
 * 위치
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package model;

public class Position {
    private int position;
    public Position () {
        setPosition(1);
    }

    public int getPosition () {
        return position;
    }

    public void setPosition (int position) {
        this.position = position;
    }
}
