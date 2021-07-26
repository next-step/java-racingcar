package racing.util.converter;

import racing.domain.game.vo.Turns;

public class TurnsConverter implements Converter<Integer, Turns> {
    @Override
    public Turns convert(Integer input) {
        return new Turns(input);
    }

    public static TurnsConverter getInstance() {
        return TurnsConverter.InnerClazz.instance;
    }

    private static class InnerClazz {
        public static final TurnsConverter instance = new TurnsConverter();
    }
}
