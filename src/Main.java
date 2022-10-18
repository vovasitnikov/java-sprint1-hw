import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker(); //создаем объект, в котором будет вся статистика и многое другое

        while (true) {
            printMainMenu(); //вызываем главное меню
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                stepTracker.printMenu1(); //выводим меню №1
            } else if (userInput == 2) {
                stepTracker.printMenu2(); //выводим меню №2
            } else if (userInput == 3) {
                stepTracker.printMenu3(); //выводим меню №3
            } else if (userInput == 4) {
                System.out.println("Досвидания дорогой пользователь!!! Возвращайся еще :)");
                break;
            } else {
                System.out.println("Выбран не существующий пункт меню.");
            }
        }
        System.out.println("Программа завершена");
    }

    //главное меню
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