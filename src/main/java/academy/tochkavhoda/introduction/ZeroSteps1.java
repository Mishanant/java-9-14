package academy.tochkavhoda.introduction;

class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y)
    {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y; // Гарантируется, что y != 0
    }

    public int mod(int x, int y) {
        return x % y; // Гарантируется, что y != 0
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int side1, int side2) {
        return 0.5 * side1 * side2;
    }

    public double calculateTrianglePerimeter(int side1, int side2) {
        return side1 + side2 + Math.hypot(side1, side2);
    }

    public int reverseNumber(int number) {
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        return units * 100 + tens * 10 + hundreds;
    }

    public long calculate15Degree(int number) {
        long a = (long) number;
        long a2 = a * a;           // number^2
        long a4 = a2 * a2;         // number^4
        long a8 = a4 * a4;         // number^8
        long a10 = a8 * a2;        // number^{10}
        long a14 = a10 * a4;       // number^{14}
        long result = a14 * a;     // number^{15}
        return result;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    // 13. Проверяет, существует ли треугольник с такими сторонами
    public boolean isTriangleExist(int side1, int side2, int side3) {
        return (side1 + side2 > side3) &&
                (side2 + side3 > side1) &&
                (side1 + side3 > side2);
    }

    // 14. Возвращает произведение цифр четырехзначного числа
    public int getDigitsProduction(int number) {
        int digit1 = Math.abs(number / 1000);
        int digit2 = Math.abs((number / 100) % 10);
        int digit3 = Math.abs((number / 10) % 10);
        int digit4 = Math.abs(number % 10);
        return digit1 * digit2 * digit3 * digit4;
    }

    // 15. Проверяет, может ли круг поместиться внутри квадрата без касания
    public boolean isCircleInsideSquare(int radius, int side) {
        // Для размещения без касания диаметр круга должен быть меньше или равен стороне квадрата
        return 2 * radius < side;
    }

    // 16. Возвращает символ по коду
    public char getCharByCode(short code) {
        return (char) code;
    }

    // 17. Возвращает код символа
    public short getCodeByChar(char character) {
        return (short) character;
    }

    // 18. Возвращает символ с кодом, на offset больше чем у ch
    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    // 19. Проверяет, больше или равно ли код ch1 коду ch2
    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }
}