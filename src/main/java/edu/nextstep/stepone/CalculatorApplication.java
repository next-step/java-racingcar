package edu.nextstep.stepone;

import java.util.List;
import java.util.Scanner;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-14 14:29
 */
public class CalculatorApplication {

    private Validation validation = new Validation();
    private StringUtils utils = new StringUtils();

    private List<String> letter;
    private static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = 2;
    private int totalNumber = 0;

    public static void main(String[] args) {
        CalculatorApplication calculator = new CalculatorApplication();

        Scanner sc = new Scanner(System.in);
        String inputData = sc.nextLine();
        sc.close();

        System.out.println(calculator.start(inputData));
    }

    public int start(String inputData) {

        if (this.validation.isNotBlank(inputData)) {
            this.letter = this.validation.splitSpace(inputData);
        }

        totalNumber = this.utils.convertInt(this.letter.get(0));

        for (int i = FIRST_INDEX; i < this.letter.size() - 2; i += LAST_INDEX) {
            OperatorType type = OperatorType.typeCheck(this.letter.get(i + 1));
            int second = this.utils.convertInt(this.letter.get(i + 2));

            totalNumber = type.calculate(totalNumber, second);
        }

        return totalNumber;
    }

}
