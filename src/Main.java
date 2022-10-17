import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int userInput; //переменная для введеного пользователем
    static int userInputMonth; //переменная для введеного пользователем месяца
    static int userInputDay; //переменная для введеного пользователем дня
    static int userInputCountSteps; //переменная для введеного пользователем количества шагов

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker(); //создаем объект, в котором будет вся статистика и многое другое

        while (true) {
            printMainMenu(); //вызываем главное меню
            userInput = scanner.nextInt();

            if (userInput < 1 || userInput > 4) {
                System.out.println("Выбран не существующий пункт меню.");
                printMainMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
                userInput = scanner.nextInt(); // повторное считывание данных от пользователя
            } else if (userInput == 1) {
                printMenu1(stepTracker); //выводим меню №1
            } else if (userInput == 2) {
                printMenu2(stepTracker); //выводим меню №2
            } else if (userInput == 3) {
                printMenu3(stepTracker); //выводим меню №3
            } else if (userInput == 4) {
                System.out.println("Досвидания дорогой пользователь!!! Возвращайся еще :)");
                break;
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
    //меню для ввода шагов за определенный день
    private static void printMenu1(StepTracker stepTracker) {
        //бесконечный цикл для меню №1
        while (true) {
            //бесконечный цикл для правильного введения месяца
            while (true) {
                System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №1----------------|");
                System.out.println("|--Ввести количество шагов за определённый день--|");
                System.out.print("Введите значение месяца от 1 до 12: ");
                userInputMonth = scanner.nextInt(); //сохраняем выбор месяца пользователем
                if (userInputMonth > 0 && userInputMonth < 13) { //месяц должен быть от 1 до 12
                    break; //добиваемся от пользователя корректного ввода месяца  выходим из цикла
                } else {
                    System.out.println("Месяц введен некорректно."); //отправляем пользователя обратно ввести месяц
                }
            }
            //бесконечный цикл для правильного введения дня месяца
            while (true) {
                System.out.print("Введите день от 1 до 30: ");
                userInputDay = scanner.nextInt(); //сохраняем выбор дня пользователем
                if (userInputDay > 0 && userInputDay < 31) {
                    break; //добиваемся от пользователя корректного ввода дня  выходим из цикла
                } else {
                    System.out.println("День введен некорректно."); //отправляем пользователя обратно ввести день
                }
            }
            //бесконечный цикл для правильного введения шагов
            while (true) {
                System.out.print("Введите количество шагов за этот день: ");
                userInputCountSteps = scanner.nextInt(); // сохраняем выбор пользователя колличества шагов
                if (userInputCountSteps > 0) {
                    //у трекера сперва поднимаем массив с объектами-месяцами
                    //находим в массиве нужный объект-месяц, который хочет пользователь
                    //далее внутри этого объекта месяца в массиве дне находим нужный день, который хочет пользователь
                    //засовываем туда введеное пользователем количество шагов
                    //в индексах отнимаем единицу, так как массив начинается с нуля
                    stepTracker.months[userInputMonth - 1].setCountStepsInDaysMonth(userInputDay - 1, userInputCountSteps);
                    System.out.println("Шаги успешно добавлены!!!!");
                    return; //добиваемся от пользователя корректного ввода шагов и  выходим из процедуры
                } else {
                    System.out.println("Шаги введены некорректно."); //отправляем пользователя обратно ввести шаги
                }
            }
        }
    }

    //меню для распечатки статистики
    private static void printMenu2(StepTracker stepTracker) {
        //бесконечный цикл для проверки корректного ввода месяца
        while (true) {
            System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №2----------------|");
            System.out.println("|---Напечатать статистику за определённый месяц--|");
            System.out.print("Введите значение месяца от 1 до 12: ");
            userInputMonth = scanner.nextInt();
            //месяц должен быть от 1 до 12
            if (userInputMonth > 0 && userInputMonth < 13) {
                break; //добиваемся от пользователя корректного ввода месяца  выходим из цикла
            } else {
                System.out.println("Месяц введен некорректно."); //отправляем пользователя обратно ввести месяц
            }
        }
        System.out.println("|-------------СТАТИСТИКА ЗА МЕСЯЦ----------------|");
        System.out.print("|--"); //штучка-дрючка для красоты меню
        //напечатаем количество шагов по дням
        stepTracker.printEverydayCountSteps(userInputMonth - 1);

        //вызываем метод, который возвращает все шаги выбранного месяца
        //не забываем, что нужно отнять от месяца единицу, так как в массиве отсчет идет с нуля
        int totalStepsMonth = stepTracker.getTotalStepsMonth(userInputMonth - 1);
        System.out.println("|--Количество шагов, пройденных за " + stepTracker.months[userInputMonth - 1].getNameMonth() + ": " + totalStepsMonth);

        //выведем максимальное количество за день в этом месяце
        System.out.println("|--Максимальное колличество шагов в день было: " + stepTracker.getMaxCountStepsDay(userInputMonth - 1));

        //найдем среднее количество шагов за месяц
        System.out.println("|--Среднее количество шагов за месяц: " + stepTracker.getAverageNumberSteps(userInputMonth - 1));

        //выведем пройденную дистанцию
        //для этого создадим объект конвертора, отправив в него общее количество шагов за месяц
        Converter converter = new Converter(totalStepsMonth);
        System.out.println("|--Пройденная дистанция (в км): " + converter.getTotalKilometers());

        //выведем сожженые калории
        System.out.println("|--Количество сожжённых килокалорий: " + converter.getTotalKilocalories());

        System.out.println("|--Цель по шагам в день была: " + stepTracker.getTargetStepsDay());
        //выведем лучшую серию из дней, в которых была выполнена поставленная цель
        System.out.println("|--Лучшая серия, в течении которой была достигнута цель по шагам, составляет (дней): " + stepTracker.getBestDaySeries(userInputMonth - 1) );

        System.out.println("|<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>|");
    }

    //меню изменения цели по шагам
    private static void printMenu3(StepTracker stepTracker) {
        while (true) {
            System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №3----------------|");
            System.out.println("|----Изменить цель по количеству шагов в день----|");
            System.out.println("Сейчас цель по шагам в день: " + stepTracker.getTargetStepsDay());
            System.out.print("Введите новую цель по шагам в день: ");
            //проверка чтобы значение шагов не было отрицательным
            userInput = scanner.nextInt();
            if (userInput >= 0) {
                stepTracker.setTargetStepsDay(userInput); //присваиваем новое значение цели по шагам
                System.out.println("Новая цель по шагам в день успешно установлена!!!");
                return; //покидаем бесконечный цикл
            } else {
                System.out.println("Вы ввели отрицательное значение. Пожалуйста введите заново!!!");
            }
        }
    }

}

