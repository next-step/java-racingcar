package stringCalculator;

public enum Operator {

    ADDITION {
        public int operate(int first, int second) { return first + second; }
    },
    SUBSTRACT {
        public int operate(int first, int second) { return first - second; }
    },
    MULTIPLICATION {
        public int operate(int first, int second) { return first * second; }
    },
    DIVIDE {
        public int operate(int first, int second) {
            if(second == 0) throw new DivideByZeroException("0으로는 나눗셈을 할 수 없습니다.");
            return first / second;
        }
    };

    public abstract int operate(int first, int second);

    static int result;

    static public int compute(String stringFomula) {

        if(stringFomula == null || stringFomula == " ")
            throw new NullAndBlankException();

        String[] splitFoumula = stringFomula.split(" ");

        for (int i = 0; i < splitFoumula.length; i++) {

            if(i == 0) result = Integer.parseInt(splitFoumula[i]);
            if(i % 2 == 1 && !("+-*/".contains(splitFoumula[i])))
                throw new NotVaildOperatorException();

            if (splitFoumula[i].equals("+"))
                result = Operator.ADDITION.operate(
                        result,
                        Integer.parseInt(splitFoumula[i + 1]));

            if (splitFoumula[i].equals("-"))
                result = Operator.SUBSTRACT.operate(
                        result,
                        Integer.parseInt(splitFoumula[i + 1]));

            if (splitFoumula[i].equals("*"))
                result = Operator.MULTIPLICATION.operate(
                        result,
                        Integer.parseInt(splitFoumula[i + 1]));

            if (splitFoumula[i].equals("/")) {
                if(Integer.parseInt(splitFoumula[i + 1]) == 0)
                    throw new DivideByZeroException();

                result = Operator.DIVIDE.operate(
                        result,
                        Integer.parseInt(splitFoumula[i + 1]));
            }
        }

        return result;
    }
}
