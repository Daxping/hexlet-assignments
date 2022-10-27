package exercise;

// BEGIN
public class Cottage implements Home{
    double area;
    int floorCount;
    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()){
            return 1;
        } else if (getArea() < another.getArea()) {
            return -1;
        }
        return 0;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
