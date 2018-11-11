package calculator2;

import java.util.ArrayList;
import java.util.List;

public class StringNumberSet {
    private List<StringNumber> numbers;

    private StringNumberSet(List<StringNumber> numbers) {
        this.numbers = numbers;
    }

    public static StringNumberSet create(String[] texts) {
        List<StringNumber> nums = new ArrayList<>();
        for (int i = 0; i < texts.length; i++) {
            nums.add(StringNumber.create(texts[i]));
        }
        return new StringNumberSet(nums);
    }

    public int sum() {
        int result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            result += numbers.get(i).getNumber();
        }
        return result;
    }
}
