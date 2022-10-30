package exercise;

import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;


// BEGIN
public class TcpConnection implements TCP {
    private Connection connection;

    public TcpConnection(String ip, int port) {
        this.connection = new Disconnected(this);
    }

    @Override
    public String getCurrentState() {
        return this.connection.state();
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void connect() {
        setConnection(new Connected(this));
        this.connection.connect();
    }

    @Override
    public void disconnect() {
        setConnection(new Disconnected(this));
        this.connection.disconnect();
    }

    @Override
    public void write(String str) {
        this.connection.write(str);
    }
}
// END
