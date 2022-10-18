import java.util.Scanner;

public class StepTracker {
    int targetStepsDay = 10000;
    public Month[] months = new Month[12];
    static Scanner scanner = new Scanner(System.in);

    public StepTracker() {
        for (int i = 0; i < 12; i++){
            months[i] = new Month(i);
        }
    }

    public int getTargetStepsDay() {
        return targetStepsDay;
    }

    public void setTargetStepsDay(int targetStepsDay) {
        this.targetStepsDay = targetStepsDay;
    }

    public   void enterNumberStepsInDay() {
        int userInputMonth;
        int userInputDay;
        int userInputCountSteps;

        while (true) {
            while (true) {
                System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №1----------------|");
                System.out.println("|--Ввести количество шагов за определённый день--|");
                System.out.print("Введите значение месяца от 1 до 12: ");
                userInputMonth = scanner.nextInt();
                if (userInputMonth > 0 && userInputMonth < 13) {
                    break;
                } else {
                    System.out.println("Месяц введен некорректно.");
                }
            }

            while (true) {
                System.out.print("Введите день от 1 до 30: ");
                userInputDay = scanner.nextInt();
                if (userInputDay > 0 && userInputDay < 31) {
                    break;
                } else {
                    System.out.println("День введен некорректно.");
                }
            }

            while (true) {
                System.out.print("Введите количество шагов за этот день: ");
                userInputCountSteps = scanner.nextInt();
                if (userInputCountSteps > 0) {
                    months[userInputMonth - 1].setCountStepsInDaysMonth(userInputDay - 1, userInputCountSteps);
                    System.out.println("Шаги успешно добавлены!!!!");
                    return;
                } else {
                    System.out.println("Шаги введены некорректно.");
                }
            }
        }
    }

    public   void monthStatistics() {
        int userInputMonth;
        int totalStepsMonth;

        while (true) {
            System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №2----------------|");
            System.out.println("|---Напечатать статистику за определённый месяц--|");
            System.out.print("Введите значение месяца от 1 до 12: ");
            userInputMonth = scanner.nextInt();
            if (userInputMonth > 0 && userInputMonth < 13) {
                break;
            } else {
                System.out.println("Месяц введен некорректно.");
            }
        }
        System.out.println("|-------------СТАТИСТИКА ЗА МЕСЯЦ----------------|");
        System.out.print("|--");
        printEverydayCountSteps(userInputMonth - 1);
        totalStepsMonth = getTotalStepsMonth(userInputMonth - 1);
        System.out.println("|--Количество шагов, пройденных за " + months[userInputMonth - 1].getNameMonth() + ": " + totalStepsMonth);
        System.out.println("|--Максимальное колличество шагов в день было: " + getMaxCountStepsDay(userInputMonth - 1));
        System.out.println("|--Среднее количество шагов за месяц в день: " + getAverageNumberSteps(userInputMonth - 1));
        Converter converter = new Converter();
        System.out.println("|--Пройденная дистанция (в км): " + converter.getTotalKilometers(totalStepsMonth));
        System.out.println("|--Количество сожжённых килокалорий: " + converter.getTotalKilocalories(totalStepsMonth));
        System.out.println("|--Цель по шагам в день была: " + getTargetStepsDay());
        System.out.println("|--Лучшая серия, в течении которой была достигнута цель по шагам, составляет (дней): " + getBestDaySeries(userInputMonth - 1) );
        System.out.println("|<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>|");
    }

    public   void changeTargetSteps() {
        int userInput;
        while (true) {
            System.out.println("|--------ВЫ ВЫБРАЛИ ПУНКТ МЕНЮ №3----------------|");
            System.out.println("|----Изменить цель по количеству шагов в день----|");
            System.out.println("Сейчас цель по шагам в день: " + getTargetStepsDay());
            System.out.print("Введите новую цель по шагам в день: ");
            userInput = scanner.nextInt();
            if (userInput >= 0) {
                setTargetStepsDay(userInput);
                System.out.println("Новая цель по шагам в день успешно установлена!!!");
                return;
            } else {
                System.out.println("Вы ввели отрицательное значение. Пожалуйста введите заново!!!");
            }
        }
    }

    public int getTotalStepsMonth(int userInputMonth){
        int totalStepsMonth = 0;
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            totalStepsMonth += countStepsInDaysMonth[i];
        }
        return totalStepsMonth;
    }

    public int getMaxCountStepsDay(int userInputMonth){
        int maxCountStepsMonth = 0;
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
        int searchBestDaySeries = 0;
        int bestDaySeries = 0;
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            if(countStepsInDaysMonth[i] >= targetStepsDay){
                searchBestDaySeries++;
            } else {
                if(searchBestDaySeries > bestDaySeries){
                    bestDaySeries = searchBestDaySeries;
                    searchBestDaySeries = 0;
                }
            }
        }
        return bestDaySeries;
    }
}