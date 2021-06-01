package RentCompany;

public class Avante extends Car{
    private static final int EFFICIENCY =10;
    private int distance;

    public Avante(int distance) {
        this.distance = distance;

    }

    @Override
    double getDistancePerLiter() {

        return (double)distance / EFFICIENCY;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    String getName() {
        return "Avante";
    }


}
