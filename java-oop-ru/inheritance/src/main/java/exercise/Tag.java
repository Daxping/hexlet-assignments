package exercise;

import java.util.List;
import java.util.Map;

// BEGIN
public class Tag {
    String name;
    Map<String, String> attributes;
    String body;
    List<Tag> tags;

    public String toString() {
        StringBuilder attr = new StringBuilder();
        for (String x : this.attributes.keySet()) {
            attr
                    .append(x)
                    .append("=")
                    .append("\"")
                    .append(this.attributes.get(x))
                    .append("\"")
                    .append(" ");
        }
        String str = attr.toString().trim();
        return str.equals("") ? "<" + name + ">" : "<" + name + " " + str + ">";
    }
}
// END
