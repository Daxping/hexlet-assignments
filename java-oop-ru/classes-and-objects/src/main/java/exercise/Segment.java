package exercise;

// BEGIN
public class Segment {
    private final Point beginPoint;
    private final Point endPoint;


    public Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getBeginPoint() {
        return this.beginPoint;
    }

    public Point getEndPoint() {
        return this.endPoint;
    }

    public Point getMidPoint() {
        int x = (this.beginPoint.getX() + this.endPoint.getX()) / 2;
        int y = (this.beginPoint.getY() + this.endPoint.getY()) / 2;
        return new Point(x, y);
    }
}
// END
