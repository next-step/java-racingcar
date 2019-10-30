package stringcalculator.business;

import java.util.Stack;

class Memory {

    private Stack<Operand> operands;
    private Stack<Operator> operators;

    Memory() {
        this.operands = new Stack<>();
        this.operators = new Stack<>();
    }

    void store(final Unit unit) {
        if (unit.getType() == Unit.OPERAND) {
            operands.push((Operand) unit);
            return;
        }

        operators.push((Operator) unit);
    }

    Stack<Operand> getOperands() {
        return this.operands;
    }

    Stack<Operator> getOperators() {
        return this.operators;
    }

}
