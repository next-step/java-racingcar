package racinggame.domain.fixture;

import racinggame.domain.Names;

public class NamesFixture {
    public static final String ENTRY_CAR_NAMES = "jae,han";

    public static Names createNames() throws Exception {
        return createNames(ENTRY_CAR_NAMES);
    }

    public static Names createNames(String text) throws Exception {
        return Names.from(text);
    }
}
