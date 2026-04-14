package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle {
    // Поля
    private Point topLeft;        // Левая верхняя точка
    private Point bottomRight;    // Правая нижняя точка
    private int color;            // Цвет (номер в палитре)

    // Конструктор 1: по двум точкам и цвету
    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        this.topLeft = new Point(leftTop.getX(), leftTop.getY());
        this.bottomRight = new Point(rightBottom.getX(), rightBottom.getY());
        this.color = color;
    }

    // Конструктор 2: по координатам и цвету
    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this.topLeft = new Point(xLeft, yTop);
        this.bottomRight = new Point(xRight, yBottom);
        this.color = color;
    }

    // Конструктор 3: по длине, ширине, цвету, левый нижний в начале координат
    public ColoredRectangle(int length, int width, int color) {
        this.topLeft = new Point(0, -width);
        this.bottomRight = new Point(length, 0);
        this.color = color;
    }

    // Конструктор 4: только цвет, размеры (1,1), левый нижний в начале
    public ColoredRectangle(int color) {
        this.topLeft = new Point(0, -1);
        this.bottomRight = new Point(1, 0);
        this.color = color;
    }

    // Конструктор 5: по умолчанию
    public ColoredRectangle() {
        this.topLeft = new Point(0, -1);
        this.bottomRight = new Point(1, 0);
        this.color = 1;
    }

    // Метод 6: getTopLeft
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    // Метод 7: getBottomRight
    public Point getBottomRight() {
        return new Point(bottomRight.getX(), bottomRight.getY());
    }

    // Метод 8: getColor
    public int getColor() {
        return color;
    }

    // Метод 9: setTopLeft
    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    // Метод 10: setBottomRight
    public void setBottomRight(Point bottomRight) {
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
    }

    // Метод 11: setColor
    public void setColor(int color) {
        this.color = color;
    }

    // Метод 12: getLength
    public int getLength() {
        return Math.abs(bottomRight.getX() - topLeft.getX());
    }

    // Метод 13: getWidth
    public int getWidth() {
        return Math.abs(bottomRight.getY() - topLeft.getY());
    }

    // Метод 14: moveRel
    public void moveRel(int dx, int dy) {
        this.topLeft = new Point(topLeft.getX() + dx, topLeft.getY() + dy);
        this.bottomRight = new Point(bottomRight.getX() + dx, bottomRight.getY() + dy);
    }

    // Метод 14: moveTo (по условию, также есть тест)
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        this.topLeft = new Point(x, y);
        this.bottomRight = new Point(x + length, y + width);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    // Метод 15: resize
    public void resize(double ratio) {
        int length = getLength();
        int width = getWidth();

        int newLength = (int) (length * ratio);
        int newWidth = (int) (width * ratio);

        int x0 = topLeft.getX();
        int y0 = topLeft.getY();

        // Левая верхняя остается
        // Правая нижняя меняется
        bottomRight = new Point(x0 + newLength, y0 + newWidth);
    }

    // Метод 16: stretch
    public void stretch(double xRatio, double yRatio) {
        int length = getLength();
        int width = getWidth();

        int newLength = (int) (length * xRatio);
        int newWidth = (int) (width * yRatio);

        int x0 = topLeft.getX();
        int y0 = topLeft.getY();

        bottomRight = new Point(x0 + newLength, y0 + newWidth);
    }

    // Метод 17: getArea
    public double getArea() {
        return getLength() * getWidth();
    }

    // Метод 18: getPerimeter
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    // Метод 19: isInside(x, y)
    public boolean isInside(int x, int y) {
        int xMin = Math.min(topLeft.getX(), bottomRight.getX());
        int xMax = Math.max(topLeft.getX(), bottomRight.getX());
        int yMin = Math.min(topLeft.getY(), bottomRight.getY());
        int yMax = Math.max(topLeft.getY(), bottomRight.getY());

        return x >= xMin && x <= xMax && y >= yMin && y <= yMax;
    }

    // Метод 20: isInside(Point)
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // Метод 21: isIntersects
    public boolean isIntersects(ColoredRectangle rectangle) {
        int thisXMin = Math.min(topLeft.getX(), bottomRight.getX());
        int thisXMax = Math.max(topLeft.getX(), bottomRight.getX());
        int thisYMin = Math.min(topLeft.getY(), bottomRight.getY());
        int thisYMax = Math.max(topLeft.getY(), bottomRight.getY());

        int rectXMin = Math.min(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int rectXMax = Math.max(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int rectYMin = Math.min(rectangle.topLeft.getY(), rectangle.bottomRight.getY());
        int rectYMax = Math.max(rectangle.topLeft.getY(), rectangle.bottomRight.getY());

        boolean noOverlap = thisXMax < rectXMin || rectXMax < thisXMin ||
                thisYMax < rectYMin || rectYMax < thisYMin;

        return !noOverlap;
    }

    // Метод 22: isInside (целиком внутри другого)
    public boolean isInside(ColoredRectangle rectangle) {
        int thisXMin = Math.min(topLeft.getX(), bottomRight.getX());
        int thisXMax = Math.max(topLeft.getX(), bottomRight.getX());
        int thisYMin = Math.min(topLeft.getY(), bottomRight.getY());
        int thisYMax = Math.max(topLeft.getY(), bottomRight.getY());

        int rectXMin = Math.min(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int rectXMax = Math.max(rectangle.topLeft.getX(), rectangle.bottomRight.getX());
        int rectYMin = Math.min(rectangle.topLeft.getY(), rectangle.bottomRight.getY());
        int rectYMax = Math.max(rectangle.topLeft.getY(), rectangle.bottomRight.getY());

        // Проверяем, что все углы rectangle внутри текущего
        boolean insideLeftUp = rectXMin >= thisXMin && rectYMin >= thisYMin;
        boolean insideRightDown = rectXMax <= thisXMax && rectYMax <= thisYMax;

        return insideLeftUp && insideRightDown;
    }

    // Методы equals и hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color &&
                topLeft.equals(that.topLeft) &&
                bottomRight.equals(that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, color);
    }
}