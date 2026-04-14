package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Circle {
    private Point center;
    private int radius;

    // Конструктор 1: по центру и радиусу
    public Circle(Point center, int radius) {
        this.center = new Point(center.getX(), center.getY());
        this.radius = radius;
    }

    // Конструктор 2: по координатам центра и радиусу
    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
    }

    // Конструктор 3: центр в (0,0), радиус
    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
    }

    // Конструктор 4: центр в (0,0), радиус 1
    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
    }

    // Геттер для центра
    public Point getCenter() {
        return new Point(center.getX(), center.getY());
    }

    // Геттер для радиуса
    public int getRadius() {
        return radius;
    }

    // Сеттер для центра
    public void setCenter(Point center) {
        this.center = new Point(center.getX(), center.getY());
    }

    // Сеттер для радиуса
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // Передвижение центра в точку (x, y)
    public void moveTo(int x, int y) {
        this.center = new Point(x, y);
    }

    // Передвижение центра в точку Point
    public void moveTo(Point point) {
        this.center = new Point(point.getX(), point.getY());
    }

    // Смещение центра на (dx, dy)
    public void moveRel(int dx, int dy) {
        this.center = new Point(center.getX() + dx, center.getY() + dy);
    }

    // Масштабирование радиуса
    public void resize(double ratio) {
        if (ratio <= 0) return; // Можно добавить обработку ошибок
        this.radius = (int) (radius * ratio);
    }

    // Площадь круга
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Длина окружности
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Проверка, внутри ли точка (x, y)
    public boolean isInside(int x, int y) {
        double distSquared = Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2);
        return distSquared <= radius * radius;
    }

    // Проверка, внутри ли точка Point
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius && center.equals(circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }

}
