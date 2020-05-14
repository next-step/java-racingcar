public abstract class Calculation {
    int num1;
    int num2;

    public Calculation(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public abstract int getResult();
}

class Plus extends Calculation {
    public Plus(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1 + num2;
    }
}

class Minus extends Calculation {
    public Minus(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1 - num2;
    }
}

class Multiply extends Calculation {
    public Multiply(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1 * num2;
    }
}

class Divide extends Calculation {
    public Divide(int num1, int num2) {
        super(num1, num2);
    }

    @Override
    public int getResult() {
        return num1 / num2;
    }
}
