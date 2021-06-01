package RentCompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");

    List<Car> carList = new ArrayList<>();

    public static RentCompany create() {
        return new RentCompany();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public String generateReport() {
        String report = "";

        for(Car car : carList){
            report += car.getName() + " : " + (int) car.getDistancePerLiter() + "리터" +NEWLINE;
        }

        return report;
    }
}
