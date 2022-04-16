package racingcar.play;
import racingcar.generator.Generator;

public class ZeroToNineRandomPolicy implements RacingGamePolicy {

    Generator<Integer, Integer> numberGenerator;

    public ZeroToNineRandomPolicy(Generator<Integer, Integer> generator) {
        numberGenerator = generator;
    }

    @Override
    public int racing(int value) {
        return numberGenerator.generate(value);
    }

}
