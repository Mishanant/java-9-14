package academy.tochkavhoda.figures.v1;

public class CircleFactory {
    private static int circleCount = 0;


    public static Circle createCircle(Point center, int radius) {
        circleCount++;
        return new Circle(center, radius);
    }

    /**
     * Возвращает количество созданных окружностей.
     *
     * @return Количество созданных окружностей.
     */
    public static int getCircleCount() {
        return circleCount;
    }

    /**
     * Сбрасывает счетчик созданных окружностей на 0.
     */
    public static void reset() {
        circleCount = 0;
    }
}
