package racegame;

import java.util.Scanner;

public class RacingName {


    String[] nameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        boolean nameCheckBoolean = true;
        String str = "";
        String[] nameList={""};
        while (nameCheckBoolean) {
            Scanner scan = new Scanner(System.in);
            str = scan.nextLine();
            nameList = str.replaceAll(" ", "").split(",");
            if (nameCheck(nameList)) {
                nameCheckBoolean = false;
            }
        }
        return nameList;
    }

    boolean nameCheck(String[] nameList) {
        boolean check = true;
        for (String carName :nameList) {
            if (carName.length() > 5) {
                check = false;
                System.out.println("글자가 5글자 넘었습니다.");
                break;
            }
        }
        return check;
    }
}
