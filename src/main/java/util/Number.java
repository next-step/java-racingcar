/*
 *   Class name : Number.java
 *   Version : 0.0.1
 *   Date : 2021/08/09
 */

package util;

import java.util.Random;

/**
 * 숫자와 관련된 처리를 하는 클래스입니다.
 */
public class Number {

    public static int getRandomNum(int range) {
        Random moveIndex = new Random();
        int move = moveIndex.nextInt(range);
        return move;
    }

}
