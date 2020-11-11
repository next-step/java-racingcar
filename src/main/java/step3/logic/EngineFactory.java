package step3.logic;

@FunctionalInterface
public interface EngineFactory {
    Engine createEngine();

    EngineFactory PERFECT_ENGINE_FACTORY = () -> Engine.PERFECT_ENGINE;
    EngineFactory BROKEN_ENGINE_FACTORY  = () -> Engine.BROKEN_ENGINE;
}
