package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    String str;
    int i;
    ReversedSequence(String text) {
        this.str = reverse(text);
    }

    public String reverse(String text) {
        StringBuilder result = new StringBuilder();
        for (i = text.length() - 1; i >= 0; i--) {
            result.append(text.charAt(i));
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return str;
    }
    @Override
    public int length() {
        return str.length();
    }

    @Override
    public char charAt(int i) {
        return str.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return str.subSequence(i, i1);
    }
}
// END
