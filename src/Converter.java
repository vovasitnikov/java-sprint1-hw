public class Converter {
    private double oneStepKilometers = 0.00075; //растояние 1 шага в километрах
    private double oneStepKilocalories = 0.05; //расход килокалорий на 1 шаг

    public double getTotalKilocalories(int countSteps) {
        return countSteps * oneStepKilocalories; //подсчет калорий по пройденным шагам
    }
    public double getTotalKilometers(int countSteps) {
        return  countSteps * oneStepKilometers; //подсчет пройденного расстояния в метрах
    }
}