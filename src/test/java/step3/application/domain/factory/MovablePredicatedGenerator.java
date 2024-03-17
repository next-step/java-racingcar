package step3.application.domain.factory;

import step3.application.generator.MovableGenerator;

public class MovablePredicatedGenerator implements MovableGenerator {

    @Override
    public boolean drawMovable() {
        return false;
    }
}