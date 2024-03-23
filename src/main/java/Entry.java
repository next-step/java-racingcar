public class Entry {
    public String[] splitEntry(String input) {
        String splitPoint = ",";

        String[] entryCars = removeGap(input).split(splitPoint);

        return entryCars;
    }

    private String removeGap(String input) {
        return input.replace(" ", "");
    }
}
