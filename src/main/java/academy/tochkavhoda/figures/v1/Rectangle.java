package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point leftTop, Point rightBottom) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.bottomRight = new Point(rightBottom.getX(), rightBottom.getY());
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
    }

    public Rectangle(int length, int width) {
        // Левый нижний угол: (0, 0)
        // Верхняя левая точка: (0, -width)
        // Правая нижняя точка: (length, 0)
        // Верхняя правая точка: (length, -width)
        this.topLeft = new Point(0, -width);
        this.bottomRight = new Point(length, 0);
    }

    public Rectangle() {
        this.topLeft = new Point(0, -1);
        this.bottomRight = new Point(1, 0);
    }

    // 5. getTopLeft
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    // 6. getBottomRight
    public Point getBottomRight() {
        return new Point(bottomRight.getX(), bottomRight.getY());
    }

    // 7. setTopLeft
    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    // 8. setBottomRight
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
    }

    // 9. getLength (по оси X)
    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    // 10. getWidth (по оси Y)
    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    // 11. moveTo по координатам
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.topLeft = new Point(x, y);
        this.bottomRight = new Point(x + length, y + width);
    }

    // 12. moveTo по точке
    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // 13. moveRel
    public void moveRel(int dx, int dy) {
        this.topLeft.setX(this.topLeft.getX() + dx);
        this.topLeft.setY(this.topLeft.getY() + dy);
        this.bottomRight.setX(this.bottomRight.getX() + dx);
        this.bottomRight.setY(this.bottomRight.getY() + dy);
    }

    // 14. resize (изменение обеих сторон при сохранении левой верхней точки)
    public void resize(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ratio must be positive");
        }
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);
        this.bottomRight = new Point(this.topLeft.getX() + newLength, this.topLeft.getY() + newWidth);
    }

    // 15. stretch (изменение длины и ширины при сохранении левой верхней точки)
    public void stretch(double xRatio, double yRatio) {
        if (xRatio <= 0 || yRatio <= 0) {
            throw new IllegalArgumentException("Ratios must be positive");
        }
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);
        this.bottomRight = new Point(this.topLeft.getX() + newLength, this.topLeft.getY() + newWidth);
    }

    // 16. getArea
    public double getArea() {
        return getLength() * getWidth();
    }

    // 17. getPerimeter
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    // 18. isInside (по точкам)
    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    // 19. isInside (по точке)
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // 20. isIntersects (с другим прямоугольником)
    public boolean isIntersects(Rectangle rectangle) {
        // Пересечение, если есть хотя бы одна общая точка
        return !(rectangle.topLeft.getX() > this.bottomRight.getX() ||
                rectangle.bottomRight.getX() < this.topLeft.getX() ||
                rectangle.topLeft.getY() > this.bottomRight.getY() ||
                rectangle.bottomRight.getY() < this.topLeft.getY());
    }

    // 21. isInside (весь другой прямоугольник внутри этого)
    public boolean isInside(Rectangle rectangle) {
        return this.containsPoint(rectangle.topLeft) && this.containsPoint(rectangle.bottomRight);
    }

    // Вспомогательный метод для проверки, внутри ли точка
    private boolean containsPoint(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // переопределение equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft) &&
                Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}