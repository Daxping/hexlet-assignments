package exercise;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import static exercise.Car.*;


// BEGIN
public class App {
    public static void save(Path path, Car car) throws Exception {
        Files.writeString(path, serialize(car));
    }

    public static Car extract(Path path) throws Exception {
        return unserialize(Files.readString(path));
    }

}
// END
