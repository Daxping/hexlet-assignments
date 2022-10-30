package exercise;

public interface TCP {
    String getCurrentState();
    void connect();
    void disconnect();
    void write(String str);
}
