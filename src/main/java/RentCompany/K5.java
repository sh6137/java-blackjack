package RentCompany;

public class K5 extends Car{
    private static final int EFFICIENCY =13;
    private int distance;

    public K5(int distance) {
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
        return "K5";
    }

}
