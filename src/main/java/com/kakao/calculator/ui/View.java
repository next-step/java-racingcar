package com.kakao.calculator.ui;

import java.io.InputStream;
import java.util.Scanner;

public class View {

    private View() {
    }

    public static String inputExpression(InputStream input) {
        System.out.print("계산식을 입력해주세요 : ");
        return new Scanner(input).nextLine();
    }

}
