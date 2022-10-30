package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection connection;

    public Connected (TcpConnection connection) {
        this.connection = connection;
    }

    @Override
    public String state() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Connection is already connected!");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnected");

    }

    @Override
    public void write(String str) {
        System.out.println("wrote");

    }
}
// END
