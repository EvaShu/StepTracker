public class Converter {
    double distCoef = 0.00075;
    double kkalCoef = 50.0/1000.0;

    double stepsToKm(double steps) {
        return steps * distCoef;
    }

    double stepsToKkal(double steps) {
        return steps * kkalCoef;
    }
}
