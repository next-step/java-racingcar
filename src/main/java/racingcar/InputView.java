package racingcar;

import java.util.Scanner;

public class InputView {

    public static int[] input(){
        int[] inputValues = new int[2];
        Scanner sc = new Scanner(System.in);

        System.out.println("자동차 대수는 몇 대 인가요?");
        inputValues[0] = sc.nextInt();
        System.out.println("시도할 회수는 몇 회 인가요?");
        inputValues[1] = sc.nextInt();

        return inputValues;
    }

}
