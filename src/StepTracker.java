import java.util.Scanner;

public class StepTracker {
    int countSteps;
    int targetStepsDay = 10000;
    public Month[] months = new Month[12];
    static Scanner scanner = new Scanner(System.in);


    public StepTracker() {
        //при создании объекта создадим  массив из объектов-месяцев
        for (int i = 0; i < 12; i++){
            months[i] = new Month(i);
        }
    } // конструктор

    public int getTargetStepsDay() {
        return targetStepsDay;
    } //геттер чтобы узнать текущую цель

    public void setTargetStepsDay(int targetStepsDay) {
        this.targetStepsDay = targetStepsDay;
    } //сеттер для нового значения цели по шагам

    //меню для внесения шагов
    public   void printMenu1() {
        int userInputMonth;
        int userInputDay;
        int userInputCountSteps;
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
                    months[userInputMonth - 1].setCountStepsInDaysMonth(userInputDay - 1, userInputCountSteps);
                    System.out.println("Шаги успешно добавлены!!!!");
                    return; //добиваемся от пользователя корректного ввода шагов и  выходим из процедуры
                } else {
                    System.out.println("Шаги введены некорректно."); //отправляем пользователя обратно ввести шаги
                }
            }
        }
    }

    //меню для распечатки статистики
    public   void printMenu2() {
        int userInputMonth;
        int totalStepsMonth;
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
        printEverydayCountSteps(userInputMonth - 1);

        //вызываем метод, который возвращает все шаги выбранного месяца
        //не забываем, что нужно отнять от месяца единицу, так как в массиве отсчет идет с нуля
        totalStepsMonth = getTotalStepsMonth(userInputMonth - 1);
        System.out.println("|--Количество шагов, пройденных за " + months[userInputMonth - 1].getNameMonth() + ": " + totalStepsMonth);

        //выведем максимальное количество за день в этом месяце
        System.out.println("|--Максимальное колличество шагов в день было: " + getMaxCountStepsDay(userInputMonth - 1));

        //найдем среднее количество шагов за месяц
        System.out.println("|--Среднее количество шагов за месяц в день: " + getAverageNumberSteps(userInputMonth - 1));

        //выведем пройденную дистанцию
        //для этого создадим объект конвертора, отправив в него общее количество шагов за месяц
        Converter converter = new Converter();
        System.out.println("|--Пройденная дистанция (в км): " + converter.getTotalKilometers(totalStepsMonth));

        //выведем сожженые калории
        System.out.println("|--Количество сожжённых килокалорий: " + converter.getTotalKilocalories(totalStepsMonth));

        System.out.println("|--Цель по шагам в день была: " + getTargetStepsDay());
        //выведем лучшую серию из дней, в которых была выполнена поставленная цель
        System.out.println("|--Лучшая серия, в течении которой была достигнута цель по шагам, составляет (дней): " + getBestDaySeries(userInputMonth - 1) );

        System.out.println("|<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>|");
    }

    //меню изменения цели по шагам
    public   void printMenu3() {
        int userInput;
        while (true) {
            System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №3----------------|");
            System.out.println("|----Изменить цель по количеству шагов в день----|");
            System.out.println("Сейчас цель по шагам в день: " + getTargetStepsDay());
            System.out.print("Введите новую цель по шагам в день: ");
            //проверка чтобы значение шагов не было отрицательным
            userInput = scanner.nextInt();
            if (userInput >= 0) {
                setTargetStepsDay(userInput); //присваиваем новое значение цели по шагам
                System.out.println("Новая цель по шагам в день успешно установлена!!!");
                return; //покидаем бесконечный цикл
            } else {
                System.out.println("Вы ввели отрицательное значение. Пожалуйста введите заново!!!");
            }
        }
    }



    //метод для получения общего количества шагов за месяц
    public int getTotalStepsMonth(int userInputMonth){
        int totalStepsMonth = 0;
        //получим массив дней и пройдемся по массиву дней в объекте-месяце
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            totalStepsMonth += countStepsInDaysMonth[i];
        }
        return totalStepsMonth;
    }

    //метод для получения максимального количества шагов за месяц
    public int getMaxCountStepsDay(int userInputMonth){
        int maxCountStepsMonth = 0;
        //получим массив дней и пройдемся по массиву дней в объекте-месяце
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            if(countStepsInDaysMonth[i] > maxCountStepsMonth){
                maxCountStepsMonth = countStepsInDaysMonth[i];
            }
        }
        return maxCountStepsMonth;
    }

    public void printEverydayCountSteps(int userInputMonth){
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            System.out.print((i + 1) + " день: " + countStepsInDaysMonth[i] + ", ");
        }
        System.out.println("");
    }

    public double getAverageNumberSteps(int userInputMonth){
        double averageNumberSteps = 0;
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            averageNumberSteps += countStepsInDaysMonth[i];
        }
        averageNumberSteps /= countStepsInDaysMonth.length;
        return averageNumberSteps;
    }

    public int getBestDaySeries(int userInputMonth){
        int searchBestDaySeries = 0; //временная переменная при поиске серии лучших дней
        int bestDaySeries = 0;

        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            //условие если достигнута цель по шагам
            if(countStepsInDaysMonth[i] >= targetStepsDay){
                searchBestDaySeries++;
            } else {
                //условие обновления лучшей серии дней
                if(searchBestDaySeries > bestDaySeries){
                    bestDaySeries = searchBestDaySeries;
                    searchBestDaySeries = 0;
                }
            }

        }
        return bestDaySeries;
    }



}