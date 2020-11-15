/*
 * 클래스 이름
 * 출력 메세지 뷰
 * 버전 정보
 * 1.0
 * 날짜
 * 2020.11.01
 * 저작권 주의
 */

package view;

import model.Race;

public class ResultView {
    public void printCars (Race race) {
        race.printCars();
        System.out.println();
    }
}
