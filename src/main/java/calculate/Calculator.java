package calculate;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Calculator {
    public int calculate(String method) {
        if (!CalculateValidator.isCalculable(method)) {
            throw new IllegalArgumentException();
        }
    
        String baseNumer = null;
        FourArithmeticalRules arithmeticalRule = null;
        String[] methodPieces = method.split(" ");
        for (String methodPiece : methodPieces) {
            if (StringUtils.isNumeric(methodPiece)) {
                if (arithmeticalRule != null) {
                    baseNumer = String.valueOf(arithmeticalRule.calculate(Integer.parseInt(baseNumer), Integer.parseInt(methodPiece)));
                    continue;
                }
                baseNumer = methodPiece;
                continue;
            }
            
            arithmeticalRule = FourArithmeticalRules.getMathSign(methodPiece);
        }
        return Integer.parseInt(baseNumer);
    }
}
