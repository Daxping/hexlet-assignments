package exercise;

import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> tags) {
        this.name = name;
        this.attributes = attributes;
        this.body = body;
        this.tags = tags;
    }

    @Override
    public String toString() {
        String str = "";
        for (Tag tag : tags) {
            str = str + tag.toString();
        }

        return super.toString() + body + str + "</" + name + ">";
    }
}
// END
