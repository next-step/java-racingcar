package Calculcator.domain;

import java.util.List;

public class Calculator {

    public double calculation(String expression) {
        List<String> elements = Splitter.split(expression);

        Operand result = new Operand(elements.get(0));

        for (int i = 1; i < elements.size(); i += 2) {
            Operator operator = Operator.findBySymbol(elements.get(i));
            Operand operand = new Operand(elements.get(i + 1));

            result = operator.compute(result, operand);
        }

        return result.getValue();
    }

}
