import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            printMainMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.enterNumberStepsInDay();
            } else if (userInput == 2) {
                stepTracker.monthStatistics();
            } else if (userInput == 3) {
                stepTracker.changeTargetSteps();
            } else if (userInput == 4) {
                System.out.println("Досвидания дорогой пользователь!!! Возвращайся еще :)");
                break;
            } else {
                System.out.println("Выбран не существующий пункт меню.");
            }
        }
        System.out.println("Программа завершена");
    }

    private static void printMainMenu() {
        System.out.println("|---------ГЛАВНОЕ МЕНЮ---------------------------|");
        System.out.println("|1.Ввести количество шагов за определённый день  |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|2.Напечатать статистику за определённый месяц   |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|3.Изменить цель по количеству шагов в день      |");
        System.out.println("|------------------------------------------------|");
        System.out.println("|4.Выйти из приложения                           |");
        System.out.println("|------------------------------------------------|");
        System.out.print("Выберите пункт меню: ");
    }
}