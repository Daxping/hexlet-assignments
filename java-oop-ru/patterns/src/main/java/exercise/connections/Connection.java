package exercise.connections;

public interface Connection {
    // BEGIN
    void connect();
    void disconnect();
    void write(String str);
    String state();
    // END
}
