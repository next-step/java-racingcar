package stepone;

import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 00:12
 *
 * description  : 문자열을 입력받고 사칙연산 수행을 위해 정제하는 클래스
 */
public class CharacterNormalization {

    /*
    문자열 입력받기 (문자열 조합은 숫자와 연산자로 받기)
     */
    public String doInputString() {

        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();
        sc.close();

        return inputData;
    }

    /*
    숫자와 연산자를 분리하기. (return type String[])
     */
    public String getDividString(String inputData) {

        // 정해진 문자열이 입력됐다는 가정 ( 숫자-공백-연산자-숫자 ex) 1 + 2 )
        String returnString = doCheckSpace(inputData);

        return returnString;

    }

    /*
    공백을 기준으로 String 반환
     */
    String doCheckSpace(String str) {

        StringBuilder builder = new StringBuilder();
        String[] tempArray = str.split(" ");

        for (String s : tempArray) {
            builder.append(s);
        }

        return builder.toString();
    }


}
