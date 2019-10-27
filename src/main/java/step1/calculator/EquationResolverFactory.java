package step1.calculator;

public class EquationResolverFactory {
    public static EquationResolver getEquationResolver(String type) {
        switch (type.toLowerCase()) {
            case "integer" :
                return IntegerEquationResolver.getInstance();

            default:
                throw new IllegalArgumentException("Unsupported operation type");
        }
    }
}
