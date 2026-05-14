import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three sides of the triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        System.out.print("Enter a color: ");
        String color = input.next();
        System.out.print("Is the triangle filled (true/false)? ");
        boolean filled = input.nextBoolean();
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);
        triangle.setFilled(filled);
        System.out.println("\n--- Triangle Details ---");
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.print("Coloring Instructions: ");
        triangle.howToColor();
        input.close();
    }
}
interface Colorable {
    void howToColor();
}
abstract class GeometricObject implements Colorable {
    private String color = "white";
    private boolean filled;
    private Date dateCreated;
    protected GeometricObject() {
        dateCreated = new Date();
    }
    protected GeometricObject(String color, boolean filled) {
        this();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public boolean isFilled() { return filled; }
    public void setFilled(boolean filled) { this.filled = filled; }
    public Date getDateCreated() { return dateCreated; }
    public abstract double getArea();
    public abstract double getPerimeter();
}
class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public Triangle() {}
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all three sides with a brush.");
    }
}
