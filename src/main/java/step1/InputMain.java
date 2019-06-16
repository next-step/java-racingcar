package step1;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMain {

    // 1. 사용자 입력을 받는다.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 1-1. NullCheck
        ValidationCheck vCheck = new ValidationCheck();
        vCheck.nullCheck(str);

        // 1-2. operatorCheck
        Calculator cal = new Calculator();
        final String[] data = str.split(" ");
        int answer = Integer.parseInt(data[0]);

        for(int i =1; i < data.length; i+=2){
            vCheck.operatorCheck(data[i]);
//            answer =

        }


    }

}


