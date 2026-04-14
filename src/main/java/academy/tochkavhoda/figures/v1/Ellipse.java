package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Ellipse {
    private Point center;
    private int xAxis;
    private int yAxis;

    // Конструкторы и остальные методы остаются как в первом варианте
    public Ellipse(Point center, int xAxis, int yAxis) {
        this.center = new Point(center.getX(), center.getY());
        this.xAxis = Math.max(1, xAxis);
        this.yAxis = Math.max(1, yAxis);
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = Math.max(1, xAxis);
        this.yAxis = Math.max(1, yAxis);
    }

    public Ellipse(int xAxis, int yAxis) {
        this.center = new Point(0, 0);
        this.xAxis = Math.max(1, xAxis);
        this.yAxis = Math.max(1, yAxis);
    }

    public Ellipse() {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
    }

    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = Math.max(1, xAxis);
    }

    public void setYAxis(int yAxis) {
        this.yAxis = Math.max(1, yAxis);
    }

    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    public void moveTo(Point point) {
        this.center = new Point(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    public void resize(double ratio) {
        if (ratio > 0) {
            setXAxis((int) Math.round(xAxis * ratio));
            setYAxis((int) Math.round(yAxis * ratio));
        }
    }

    public void stretch(double xRatio, double yRatio) {
        if (xRatio > 0 && yRatio > 0) {
            setXAxis((int) Math.round(xAxis * xRatio));
            setYAxis((int) Math.round(yAxis * yRatio));
        }
    }

    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    public double getPerimeter() {
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;

        // Простая приближенная формула
        return 2 * Math.PI * Math.sqrt((a * a + b * b) / 2);
    }

    // ВАРИАНТ 1: Проверка через ограничивающий прямоугольник
    public boolean isInside(int x, int y) {
        // Временно добавим вывод для диагностики
        System.out.println("Testing point (" + x + ", " + y + ") with ellipse: center=(" +
                center.getX() + ", " + center.getY() + "), axes=(" +
                xAxis + ", " + yAxis + ")");

        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        double dx = x - center.getX();
        double dy = y - center.getY();
        double value = (dx * dx) / (a * a) + (dy * dy) / (b * b);
        boolean result = value <= 1.0;

        System.out.println("dx=" + dx + ", dy=" + dy + ", value=" + value + ", result=" + result);
        return result;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;
        Ellipse ellipse = (Ellipse) o;
        return xAxis == ellipse.xAxis &&
                yAxis == ellipse.yAxis &&
                Objects.equals(center, ellipse.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis);
    }
}