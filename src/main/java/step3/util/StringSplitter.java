package step3.util;

import java.util.List;

public class StringSplitter {

    public List<String> getNameList(String nameListString){
        return List.of(nameListString.split(","));
    }
}
