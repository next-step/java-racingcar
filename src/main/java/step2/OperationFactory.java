package step2;

import step2.FourOperation.Operation;

public interface OperationFactory {
    Operation getOperation(String operation);
}
