abstract class GeometricObject {
    protected GeometricObject() {}
    public abstract double getArea();
    public abstract double getPerimeter();
}
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        this.side = 0;
    }
    public Octagon(double side) {
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }
    @Override
    public double getPerimeter() {
        return 8 * side;
    }
    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea()) return 1;
        if (this.getArea() < o.getArea()) return -1;
        return 0;
    }
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Create an octagon with a side length of 5
        Octagon oct1 = new Octagon(5);
        System.out.println("Octagon 1 Area: " + oct1.getArea());
        System.out.println("Octagon 1 Perimeter: " + oct1.getPerimeter());
        Octagon oct2 = (Octagon) oct1.clone();
        int result = oct1.compareTo(oct2);
        if (result == 0) {
            System.out.println("Success: The clone is equal to the original octagon.");
        } else {
            System.out.println("Error: The clone is not equal.");
        }
    }
}