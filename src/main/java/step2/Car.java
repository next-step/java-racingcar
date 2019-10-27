/*
* Car.java  1.0.0   2019.10.27
*/
package step2;


/**
 * 자동차 게임의 대상인 자동차
 * @version 1.0.0
 * @author naheenosaur
 */
public class Car {
    public int score = 0;

    public void go() {
        boolean possibleToGo = isPossibleToGo();
        ahead(possibleToGo);
    }

    void ahead(boolean is) {
        if (is) {
            score++;
        }
    }

    private boolean isPossibleToGo() {
        int random = (int) (Math.random() * 10);
        return random >= 4;
    }

}
