package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {

    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }

    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    public int prodDigits(int value) {
        int prod = 1;
        int absValue = Math.abs(value);
        while (absValue > 0) {
            int digit = absValue % 10;
            prod *= digit;
            absValue /= 10;
        }
        return prod;
    }

    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        int a = 0, b = 1, temp;
        for (int i = 2; i <= number; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public long sum2Powers(int max) {
        long sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += (long) Math.pow(2, i);
        }
        return sum;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }
    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int prod = i * j;
                if (prod < barrier) {
                    sum += prod;
                }
            }
        }
        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }
    public double calculateE() {
        double sum = 1.0;
        int n = 1;
        while (true) {
            double term = 1.0 / factorial(n);
            if (term < 1E-6) {
                break;
            }
            sum += term;
            n++;
        }
        return sum;
    }


    public double calculatePi() {
        double sum = 0.0;
        int n = 0;
        double term;
        do {
            n++;
            term = 4.0 * Math.pow(-1, n + 1) / (2 * n - 1);
        } while (Math.abs(term) >= 1E-8);
        // Суммируем все члены до последнего
        sum = 0.0;
        n = 0;
        do {
            n++;
            term = 4.0 * Math.pow(-1, n + 1) / (2 * n - 1);
            sum += term;
        } while (Math.abs(term) >= 1E-8);
        return sum;
    }

    public double calculateCircleSquare(double length, int count) {
        Random rand = new Random();
        int k = 0; // количество точек внутри круга
        double radius = length / 2.0;
        double centerX = length / 2.0;
        double centerY = length / 2.0;

        for (int i = 0; i < count; i++) {
            double x = rand.nextDouble() * length;
            double y = rand.nextDouble() * length;
            double dx = x - centerX;
            double dy = y - centerY;
            if (dx * dx + dy * dy <= radius * radius) {
                k++;
            }
        }
        return (length * length * k) / (double) count;
    }

}
