package com.ssabae.nextstep.racingcar.step02;

import java.util.Scanner;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-02
 */
public class CalculateApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Validator<String[]> validator = new StringCalculateValidator();
        Calculator calculator = new StringCalculator(validator);
        int result = calculator.calculate(input);

        System.out.println("result = " + result);
    }
}
