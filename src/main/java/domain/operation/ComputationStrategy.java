package domain.operation;


import domain.Operand;

interface ComputationStrategy {
    Operand compute(Operand input, Operand operand);
}
