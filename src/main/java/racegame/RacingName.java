package racegame;

import java.util.Scanner;

public class RacingName {


    String[] nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        boolean nameCheck = true;
        String str = "";
        while (nameCheck) {
            Scanner scan = new Scanner(System.in);
            str = scan.nextLine();
            if (nameCheck(str)) {
                nameCheck = false;
            }
        }
        String[] nameList = str.replaceAll(" ", "").split(",");

        System.out.println(nameList.length);
        return nameList;
    }

    boolean nameCheck(String nameList) {
        boolean check = true;
        String[] names = nameList.replaceAll(" ", "").split(",");
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > 5) {
                check = false;
                System.out.println("글자가 5글자 넘었습니다.");
                break;
            }
        }
        return check;
    }
}
