package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    Map <String, String> storage;
    String path;

    FileKV(String path, Map<String, String> map) {
        this.path = path;
        storage = new HashMap<>(map);
        Utils.writeFile(path, Utils.serialize(storage));
    }
    @Override
    public void set(String key, String value) {
        storage = Utils.unserialize(Utils.readFile(path));
        storage.put(key, value);
        Utils.writeFile(path, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage = Utils.unserialize(Utils.readFile(path));
        storage.remove(key);
        Utils.writeFile(path, Utils.serialize(storage));

    }

    @Override
    public String get(String key, String defaultValue) {
        storage = Utils.unserialize(Utils.readFile(path));
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
