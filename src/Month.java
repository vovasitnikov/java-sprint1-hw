public class Month {
    private String nameMonth;
    private int[] countStepsInDaysMonth = new int[30];
    public Month(int numberMonth) {
        if(numberMonth == 0) {
            this.nameMonth = "Январь";
        } else if(numberMonth == 1) {
            this.nameMonth = "Февраль";
        } else if(numberMonth == 2) {
            this.nameMonth = "Март";
        }else if(numberMonth == 3) {
            this.nameMonth = "Апрель";
        }else if(numberMonth == 4) {
            this.nameMonth = "Май";
        }else if(numberMonth == 5) {
            this.nameMonth = "Июнь";
        }else if(numberMonth == 6) {
            this.nameMonth = "Июль";
        }else if(numberMonth == 7) {
            this.nameMonth = "Август";
        }else if(numberMonth == 8) {
            this.nameMonth = "Сентябрь";
        }else if(numberMonth == 9) {
            this.nameMonth = "Октябрь";
        }else if(numberMonth == 10) {
            this.nameMonth = "Ноябрь";
        }else if(numberMonth == 11) {
            this.nameMonth = "Декабрь";
        }
    }
    public int[] getCountStepsInDaysMonth() {
        return countStepsInDaysMonth;
    }

    public void setCountStepsInDaysMonth(int numberDay, int countSteps) {
        this.countStepsInDaysMonth[numberDay] = countSteps;
    }
    public String getNameMonth() {
        return nameMonth;
    }
}