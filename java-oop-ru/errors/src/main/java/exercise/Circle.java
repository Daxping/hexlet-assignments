package exercise;

// BEGIN
public class Circle {
    final double PI = 3.1415;
    private int radius;

    public Circle(Point point, int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return this.radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (this.radius < 0) {
            throw new NegativeRadiusException("");
        } else {
            return this.radius * this.radius * PI;
        }
    }
}
// END
