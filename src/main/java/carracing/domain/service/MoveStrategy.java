package carracing.domain.service;

import java.util.function.BooleanSupplier;

public interface MoveStrategy {

  BooleanSupplier isMovable();

}
