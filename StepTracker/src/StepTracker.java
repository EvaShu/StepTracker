import java.util.Scanner;
public class StepTracker {
    int goal = 10000; //Это цель шагов
    double[][] stepsInYear = new double[12][30]; // Задаем, что у нас 12 месяцев по 30 дней
    Scanner scanner = new Scanner(System.in); // Объявили сканнер

    public void addTestData() { //Это тестовый массив за 5-й месяц, по которому можно проверить вывод статистики
        double[] testData = {10000.0, 13000.0, 13000.0, 0.0, 700.0, 6000.0, 13000.0, 13000.0, 3000.0, 0.0, 12000.0, 10500.0, 6000.0, 10500.0, 10000.0, 0.0, 10500.0, 10500.0, 6000.0, 0.0, 12000.0, 10000.0, 10500.0, 13000.0, 13000.0, 13000.0, 0.0, 10500.0, 12000.0, 0.0};
        for (int i = 0; i < 30; i++) {
            stepsInYear[4][i] = testData[i];
        }
    }

    public int changeGoal() {
        System.out.println("Укажите новую цель по шагам в день:");
        int newGoal = scanner.nextInt();
        if (newGoal < 0) {
            System.out.println("Значение не должно быть отрицательным! Укажите положительное значение:");
            newGoal = scanner.nextInt();
        } else {
            goal = newGoal;
            System.out.println("Новая цель - " + goal + " шагов");
        }
        return goal;
    }

    public void saveSteps() { //Этот метод перезаписывает кол-во шагов
        System.out.println("Укажите номер месяца от 1 до 12:");
        int m = scanner.nextInt();
        System.out.println("Укажите дату от 1 до 30:");
        int d = scanner.nextInt();
        System.out.println("Укажите количество пройденных шагов:");
        double s = scanner.nextInt();
        stepsInYear[m - 1][d - 1] = s;
        System.out.println("Сохранено! В день " + d + " месяца " + m + " вы прошли " + s + " шагов.");

    }

    void showStat() {
        // addTestData(); //Включить, чтобы проверить статистику по тестовым данным - массиву за 5-й месяц
        Converter converter = new Converter();
        System.out.println("За какой месяц вы хотите посмотреть статистику? Укажите цифру месяца от 1 до 12:");
        int monthNumber = scanner.nextInt() - 1;

        System.out.println("Количество пройденных шагов по дням:");
        for (int i = 0; i < 30; i++) {
            System.out.println((i + 1) + " день: " + stepsInYear[monthNumber][i] + " шагов");
        }
        System.out.println("Общее количество шагов за месяц:" + sumSteps(monthNumber));
        System.out.println("Максимальное пройденное количество шагов в месяце:" + maxSteps(monthNumber));
        System.out.println("Среднее количество шагов в месяц:" + averageSteps(monthNumber));
        System.out.println("Пройденная дистанция (в км):" + converter.stepsToKm(sumSteps(monthNumber)));
        System.out.println("Количество сожжённых килокалорий:" + converter.stepsToKkal(sumSteps(monthNumber)));
        System.out.println("Лучшая серия:" + bestSeries(monthNumber));
    }

    double sumSteps(int monthNumber) { //Этот метод считает сумму шагов для указанного пользователем месяца и показывает ее в методе showStat
        double sum = 0;
        for (int i = 0; i < 30; i++) {
            sum = sum + stepsInYear[monthNumber][i];
        }
        return sum;

    }

    double maxSteps(int monthNumber) {
        int max = 0;
        for (int x = 0; x < 30; x++) {
            if (stepsInYear[monthNumber][x] > max) {
                max = (int) stepsInYear[monthNumber][x];
            }
        }
        return max;
    }

    double averageSteps(int monthNumber) {
        double average = sumSteps(monthNumber) / 30;
        return average;
    }

    int bestSeries(int monthNumber) {
        int maxSeries = 0;
        int series = 0;
        for (int i = 0; i < 30; i++) {
            if (stepsInYear[monthNumber][i] >= goal) {
                series = series + 1;
            } else {
                if (series > maxSeries) {
                    maxSeries = series;
                }
                series = 0;
            }
        }
        return maxSeries;
    }
}