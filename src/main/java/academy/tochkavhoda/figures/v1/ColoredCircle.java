package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredCircle extends Circle {
    private int color;

    // Конструкторы
    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }

    public ColoredCircle(int color) {
        super(1);
        this.color = color;
    }

    public ColoredCircle() {
        this(1);
    }

    // Геттеры и сеттеры
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    // Методы работы с геометрией
    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public boolean isInside(int x, int y) {
        Point p = new Point(x, y);
        return isInside(p);
    }

    public boolean isInside(Point point) {
        int dx = point.getX() - getCenter().getX();
        int dy = point.getY() - getCenter().getY();
        return dx * dx + dy * dy <= getRadius() * getRadius();
    }

    // Методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}