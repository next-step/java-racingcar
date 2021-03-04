package study;

public enum Operation {
  ADD("+") {
    @Override
    public Integer eval(Integer lValue, Integer rValue) {
      return lValue + rValue;
    }
  },
  SUBTRACT("-") {
    @Override
    public Integer eval(Integer lValue, Integer rValue) {
      return lValue - rValue;
    }
  },
  MULTIPLY("*") {
    @Override
    public Integer eval(Integer lValue, Integer rValue) {
      return lValue * rValue;
    }
  },
  DIVIDE("/") {
    @Override
    public Integer eval(Integer lValue, Integer rValue) {
      return lValue / rValue;
    }
  };

  public final String op;

  Operation(String op) {
    this.op = op;
  }

  public abstract Integer eval(Integer lValue, Integer rValue);

  public static Operation findOperationByOperator(String op) {
    for (Operation operation : Operation.values()) {
      if (operation.op.equals(op))
        return operation;
    }
    throw new EnumConstantNotPresentException(
        Operation.class, "Not found Operation that mapped to : " + op);
  }

}
