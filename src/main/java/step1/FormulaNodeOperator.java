package step1;

interface FormulaNodeOperator<T> extends FormulaNode<T> {
    FormulaNodeValue<T> operate(final FormulaNodeValue<T> base, final FormulaNodeValue<T> other);
}
