package study.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SeparatorList {
    private Set<String> separatorSet;
    private final String REGEX_DELIMITER = "|";
    public SeparatorList() {
        this.separatorSet = new HashSet<>();
        this.add(",");
        this.add(":");
    }

    public void add(String delimiter) {
        if(delimiter == null || delimiter.trim().isEmpty()) return;
        if(this.separatorSet == null || this.separatorSet.contains(delimiter)) return;
        separatorSet.add(delimiter);
    }

    public String makeSeparatorRegex() {
        return this.separatorSet
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(REGEX_DELIMITER));
    }

}
