public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point p = (Point) obj;
        return Double.compare(p.x, x) == 0 && Double.compare(p.y, y) == 0;
    }

    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }


}
