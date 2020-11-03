package racingcar;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("자동차 대수는 몇 대 인가요?");
        String value = scanner.nextLine();
        int numOfCar = Integer.parseInt(value);
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int number = scanner.nextInt();

        Random random = new Random();

        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < numOfCar; i++) {
            hashMap.put(i, "");
        }

        System.out.println("실행 결과");


        //중첩 for문대신 stram을 사용한다
        for (int j = 0; j < number; j++) {
            for (int i = 0; i < Integer.parseInt(value); i++) {
                int randomNum = random.nextInt(10);
                if (isMovable(randomNum)) {
                    String getValue = hashMap.get(i);
                    hashMap.put(i, getValue + "-");
                }
                System.out.println(hashMap.get(i));
            }
        }

    }

    public static boolean isMovable(int randomNum){
        return randomNum>3;
    }
}
