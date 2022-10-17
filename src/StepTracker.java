public class StepTracker {
    int countSteps;
    int targetStepsDay = 10000;
    Month[] months = new Month[12];

    public StepTracker() {
        //при создании объекта создадим  массив из объектов-месяцев
        for (int i = 0; i < 12; i++){
            months[i] = new Month(i);
        }
    }

    public int getTargetStepsDay() {
        return targetStepsDay;
    } //геттер чтобы узнать текущую цель
    public void setTargetStepsDay(int targetStepsDay) {
        this.targetStepsDay = targetStepsDay;
    } //сеттер для нового значения цели по шагам

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

    void printEverydayCountSteps(int userInputMonth){
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            System.out.print((i + 1) + " день: " + countStepsInDaysMonth[i] + ", ");
        }
        System.out.println("");
    }

    public double getAverageNumberSteps(int userInputMonth){
        double averageNumberSteps = 0;
        int countDaysWithSteps = 0;
        int[] countStepsInDaysMonth = months[userInputMonth].getCountStepsInDaysMonth();
        for (int i = 0; i < countStepsInDaysMonth.length; i++){
            averageNumberSteps += countStepsInDaysMonth[i];
            if(countStepsInDaysMonth[i] > 0) {
                countDaysWithSteps++; //увеличение счетчика с днями в которых были шаги
            }
        }
        averageNumberSteps /= countDaysWithSteps;
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
