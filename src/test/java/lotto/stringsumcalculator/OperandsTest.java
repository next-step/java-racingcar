package lotto.stringsumcalculator;

import lotto.stringsumcalculator.model.Operand;
import lotto.stringsumcalculator.model.Operands;
import lotto.stringsumcalculator.model.Separators;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class OperandsTest {

    @Test
    @DisplayName("피연산자가 제대로 분리되는가")
    public void createOperands(){
        String string = "//;\\n//[\\n//]\\n1;2[3]4,5:6";

        String pattern2 = "(//.*\\\\n)(.*)";
        Matcher matcher2 = Pattern.compile(pattern2).matcher(string);

        matcher2.find();
        System.out.println("1 : " + matcher2.group(1));
        System.out.println("2 : " + matcher2.group(2));

        Separators separators = new Separators(matcher2.group(1));
        Operands operands = new Operands(matcher2.group(2) , separators);

        System.out.println(operands.getCount());

        System.out.println(separators.getCount());
        System.out.println(separators.getSeparator(0).getString());
        System.out.println(separators.getSeparator(1).getString());
        System.out.println(separators.getSeparator(2).getString());
        System.out.println(separators.getSeparator(3).getString());
        System.out.println(separators.getSeparator(4).getString());

        assertTrue(operands.getOperand(0).equals(new Operand(1)));
        assertTrue(operands.getOperand(1).equals(new Operand(2)));
        assertTrue(operands.getOperand(2).equals(new Operand(3)));
        assertTrue(operands.getOperand(3).equals(new Operand(4)));
        assertTrue(operands.getOperand(4).equals(new Operand(5)));
    }

}
