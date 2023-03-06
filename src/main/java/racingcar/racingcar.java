package racingcar;

import java.util.Scanner;

public class racingcar {
    public static void main(String input) {
        String[] ArrayCarMembers;
        int racingCount;
        Scanner scan = new Scanner(System.in);


        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String StringCarMember = scan.nextLine();
        ArrayCarMembers = StringCarMember.split(",");
        if (!validateCarlength(ArrayCarMembers)) {
            System.out.println("자동차 이름이 너무 깁니다");
            return;
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        racingCount = scan.nextInt();

        System.out.println("실행 결과");

        System.out.println("최종 우승자:");


    }


    static boolean validateCarlength(String[] ArrayCarMember) {

        for (int i = 0; i < ArrayCarMember.length; i += 1) {
            if (ArrayCarMember[i].length() > 5)
                return false;
        }
        return true;
    }


    static int RaceStart(String[] ArrayCarMembers, int racingCount) {
        for (int k = 0; k < ArrayCarMembers.length; k += 1) {
            int Array
        }

        for (int i = 0; i < racingCount; i += 1) {
            for (int j = 0; j < ArrayCarMembers.length; j += 1) {
                if (randomValue())
                    System.out.println(ArrayCarMembers[i] + " : ");

            }
        }

    }

    static boolean randomValue() {
        int randomVal = (int) (Math.random() * 10);
        if (randomVal > 3) {

            return true;
        }
        return false;
    }


}