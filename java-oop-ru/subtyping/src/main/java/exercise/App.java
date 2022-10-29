package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();

        for (String key : map.keySet()) {
            storage.unset(key);
            storage.set(map.get(key), key);
        }

    }
}
// END
