package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection connection;

    public Disconnected (TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() {
        System.out.println("connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error! Connection already disconnected");

    }

    @Override
    public String state() {
        return "disconnected";
    }


    @Override
    public void write(String str) {
        System.out.println("Error! Connection disconnected");
    }
}
// END
