package calculator;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class calculator {

    static final boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (flag) {
            String formula = new String();
            System.out.print("계산할 식을 입력하세요 : ");
            formula = sc.next();
            // chk
            System.out.println(formula);

        }
    }

    @DisplayName("test of plus method")
    @Test
    void plus() {
    }

    @DisplayName("test of minus method")
    @Test
    void minus() {
    }

    @DisplayName("test of multiple method")
    @Test
    void multiple() {
    }

    @DisplayName("test of devide method")
    @Test
    void devide() {
    }

}
