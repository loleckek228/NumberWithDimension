
import java.util.ArrayList;

public class Dimension {

    public Dimension() {

    }

    public double isCompatible(double number, String dimension, String otherDimension) {
        int coefficient;
        int otherCoefficient;
        LengthDimension lengthDimension = new LengthDimension();
        TimeDimension timeDimension = new TimeDimension();
        WeightDimension weightDimension = new WeightDimension();
        if (lengthDimension.isCompatibleLength(dimension, otherDimension, length())) {
            coefficient = getIndexCoefficient(dimension, length(), lengthDimension.lengthCoefficient());
            otherCoefficient = getIndexCoefficient(otherDimension, length(), lengthDimension.lengthCoefficient());

            return checkCoefficient(number, coefficient, otherCoefficient);
        } else if (timeDimension.isCompatibleTime(dimension, otherDimension, time())) {
            coefficient = getIndexCoefficient(dimension, time(), timeDimension.timeCoefficient());
            otherCoefficient = getIndexCoefficient(otherDimension, time(), timeDimension.timeCoefficient());

            return checkCoefficient(number, coefficient, otherCoefficient);
        } else if (weightDimension.isCompatibleWeight(dimension, otherDimension, weight())) {
            coefficient = getIndexCoefficient(dimension, weight(), weightDimension.weightCoefficient());
            otherCoefficient = getIndexCoefficient(otherDimension, weight(), weightDimension.weightCoefficient());

            return checkCoefficient(number, coefficient, otherCoefficient);
        }
        return number;
    }

    public int getIndexCoefficient(String dimension, ArrayList<String> dimensionList,
                                   ArrayList<Integer> coefficientList) {
        int coefficient = -1;
        for (int i = 0; i < dimensionList.size(); i++) {
            if (dimension.equals(dimensionList.get(i))) {
                coefficient = coefficientList.get(i);
            }
        }
        return coefficient;
    }

    public double checkCoefficient(double number, int coefficient, int otherCoefficient) {
        if (coefficient != -1 && otherCoefficient != -1)
            return getCoefficient(number, coefficient, otherCoefficient);

        return number;
    }


    public double getCoefficient(double number, int coefficient, int otherCoefficient) {
        return number * coefficient / otherCoefficient;

    }

    public ArrayList<String> length() {
        ArrayList<java.lang.String> lengthList = new ArrayList<>();
        lengthList.add("см");
        lengthList.add("дм");
        lengthList.add("м");
        lengthList.add("км");

        return lengthList;
    }

    public class LengthDimension extends Dimension {

        public LengthDimension() {
        }

        public boolean isCompatibleLength(String dimension, String otherDimension, ArrayList<String> lengthList) {
            for (int i = 0; i < lengthList.size(); i++) {
                if (dimension.equals(lengthList.get(i))) {
                    for (int j = 0; j < lengthList.size(); j++) {
                        if (otherDimension.equals(lengthList.get(j))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public ArrayList<Integer> lengthCoefficient() {
            ArrayList<Integer> coefficientLength = new ArrayList<>();
            coefficientLength.add(1);
            coefficientLength.add(10);
            coefficientLength.add(100);
            coefficientLength.add(100000);
            return coefficientLength;
        }
    }

    public ArrayList<String> time() {
        ArrayList<String> timeList = new ArrayList<>();

        timeList.add("с");
        timeList.add("м");
        timeList.add("ч");

        return timeList;
    }

    public class TimeDimension extends Dimension {

        public TimeDimension() {
        }

        public boolean isCompatibleTime(String dimension, String otherDimension, ArrayList<String> timeList) {
            for (int i = 0; i < timeList.size(); i++) {
                if (dimension.equals(timeList.get(i))) {
                    for (int j = 0; j < timeList.size(); j++) {
                        if (otherDimension.equals(time().get(j))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public ArrayList<Integer> timeCoefficient() {
            ArrayList<Integer> coefficientTime = new ArrayList<>();
            coefficientTime.add(1);
            coefficientTime.add(60);
            coefficientTime.add(3600);

            return coefficientTime;
        }
    }

    public ArrayList<String> weight() {
        ArrayList<String> weightList = new ArrayList<>();

        weightList.add("мг");
        weightList.add("гр");
        weightList.add("кг");

        return weightList;
    }

    public class WeightDimension extends Dimension {

        public WeightDimension() {
        }

        public boolean isCompatibleWeight(String dimension, String otherDimension, ArrayList<String> weightList) {
            for (int i = 0; i < weightList.size(); i++) {
                if (dimension.equals(weightList.get(i))) {
                    for (int j = 0; j < weightList.size(); j++) {
                        if (otherDimension.equals(weightList.get(j))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public ArrayList<Integer> weightCoefficient() {
            ArrayList<Integer> coefficientWeight = new ArrayList<>();

            coefficientWeight.add(1);
            coefficientWeight.add(1000);
            coefficientWeight.add(1000000);

            return coefficientWeight;
        }
    }
}



