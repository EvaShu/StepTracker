import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // Объявили сканнер
        StepTracker steptracker = new StepTracker(); //Создали объект класса StepTracker()

        while (true) {
            printMenu(); //Тут вызвали класс printMenu()
            int command = scanner.nextInt();

            if (command == 1) {
                steptracker.saveSteps();
            } else if (command == 2) {
                steptracker.showStat();
            } else if (command == 3) {
                steptracker.changeGoal();
            } else if (command == 0) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Показать статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов");
        System.out.println("0 - Выйти из приложения");
    }
}