public class Converter {
    private double oneStepKilometers = 0.00075;
    private double oneStepKilocalories = 0.05;

    public double getTotalKilocalories(int countSteps) {
        return countSteps * oneStepKilocalories;
    }
    public double getTotalKilometers(int countSteps) {
        return  countSteps * oneStepKilometers;
    }
}