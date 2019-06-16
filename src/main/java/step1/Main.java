package step1;

import java.util.Scanner;

public class Main {

    // 1. 사용자 입력을 받는다.
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 유효성 검증하기
        ValidationCheck vCheck = new ValidationCheck();
        vCheck.nullCheck(str);


    }
}
