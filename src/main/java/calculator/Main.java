package calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int result = StringCalculator.calculator(str);
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("결과 값 : {}",  result);
    }
}
