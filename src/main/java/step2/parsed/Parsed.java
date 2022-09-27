package step2.parsed;

import java.util.List;

@FunctionalInterface
public interface Parsed {

    List<String> parsedValue();

    class Fake implements Parsed {

        private final List<String> strings;

        public Fake(List<String> strings) {
            this.strings = strings;
        }

        @Override
        public List<String> parsedValue() {
            return strings;
        }
    }
    
}
