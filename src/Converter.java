public class Converter {

    private double oneStepKilometers = 0.00075; //растояние 1 шага в километрах
    private double oneStepKilocalories = 0.05; //расход килокалорий на 1 шаг
    private int countSteps;
    private double totalCalories;
    private double totalKilometers;

    public Converter(int countSteps) {
        this.countSteps = countSteps;
    }

    double getTotalKilocalories() {
        totalCalories = countSteps * oneStepKilocalories; //подсчет калорий по пройденным шагам
        return totalCalories;
    }

    double getTotalKilometers() {
        totalKilometers =  countSteps * oneStepKilometers; //подсчет пройденного расстояния в метрах
        return totalKilometers;
    }

}
