package racinggame.domain;

import java.util.List;

public class CommaPatternNames implements Names {

    private String names;

    public CommaPatternNames(String names) {
        if(names==null){
            throw new NullPointerException();
        }
        this.names = names;
    }

    @Override
    public List<String> split() {
        return toList(splitNames());
    }

    private String[] splitNames() {
        return this.names.split(",");
    }

    private List<String> toList(String[] names) {
        return List.of(names);
    }
}
