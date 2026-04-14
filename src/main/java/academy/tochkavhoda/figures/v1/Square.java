package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;
    private int size;

    // 1. Конструктор по левому верхнему углу и размеру
    public Square(Point topLeft, int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.size = size;
    }

    // 2. Конструктор по координатам левого верхнего угла и размеру
    public Square(int xLeft, int yTop, int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    // 3. Конструктор по размеру, левый нижний угол в (0, 0)
    public Square(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");
        // Чтобы левый нижний угол был в (0, 0), 
        // левый верхний должен быть в (0, -size)
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    // 4. Конструктор по умолчанию
    public Square() {
        this.topLeft = new Point(0, -1); // левый верхний в (0, -1)
        this.size = 1;
    }

    // 5. Получить левую верхнюю точку
    public Point getTopLeft() {
        return new Point(topLeft.getX(), topLeft.getY());
    }

    // 6. Получить правую нижнюю точку
    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    // 7. Установить левую верхнюю точку
    public void setTopLeft(Point topLeft) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
    }

    // 8. Получить длину стороны
    public int getLength() {
        return size;
    }

    // 9. Переместить в точку (x, y) - левый верхний угол
    public void moveTo(int x, int y) {
        this.topLeft = new Point(x, y);
    }

    // 10. Переместить в точку point - левый верхний угол
    public void moveTo(Point point) {
        this.topLeft = new Point(point.getX(), point.getY());
    }

    // 11. Переместить относительно текущего положения
    public void moveRel(int dx, int dy) {
        this.topLeft = new Point(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    // 12. Изменить размер
    public void resize(double ratio) {
        if (ratio <= 0) throw new IllegalArgumentException("Ratio must be positive");
        this.size = (int) (this.size * ratio);
    }

    // 13. Получить площадь
    public double getArea() {
        return (double) size * size;
    }

    // 14. Получить периметр
    public double getPerimeter() {
        return 4.0 * size;
    }

    // 15. Проверить, лежит ли точка внутри
    public boolean isInside(int x, int y) {
        int left = topLeft.getX();
        int top = topLeft.getY();
        int right = left + size;
        int bottom = top + size;

        return x >= left && x <= right && y >= top && y <= bottom;
    }

    // 16. Проверить, лежит ли точка внутри
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // 17. Проверить пересечение с другим квадратом
    // Альтернативная версия методов пересечения и вложенности
    public boolean isIntersects(Square square) {
        // Простая и понятная логика
        int left1 = this.topLeft.getX();
        int right1 = left1 + this.size;
        int top1 = this.topLeft.getY();
        int bottom1 = top1 + this.size;

        int left2 = square.topLeft.getX();
        int right2 = left2 + square.size;
        int top2 = square.topLeft.getY();
        int bottom2 = top2 + square.size;

        // Нет пересечения если один квадрат полностью слева/справа/сверху/снизу от другого
        if (right1 < left2 || left1 > right2) return false; // нет пересечения по X
        if (bottom1 < top2 || top1 > bottom2) return false; // нет пересечения по Y

        return true;
    }

    public boolean isInside(Square square) {
        // Проверяем, что квадрат square полностью внутри текущего
        int left1 = this.topLeft.getX();
        int right1 = left1 + this.size;
        int top1 = this.topLeft.getY();
        int bottom1 = top1 + this.size;

        int left2 = square.topLeft.getX();
        int right2 = left2 + square.size;
        int top2 = square.topLeft.getY();
        int bottom2 = top2 + square.size;

        return left2 >= left1 && right2 <= right1 && top2 >= top1 && bottom2 <= bottom1;
    }

    // 19. equals и hashCode (сгенерировать в IDEA)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}
