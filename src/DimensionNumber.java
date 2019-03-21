
public class DimensionNumber implements Comparable<DimensionNumber> {
    private double number;
    private String dimension;

    public DimensionNumber(double number, String dimension) {
        this.number = number;
        this.dimension = dimension;
    }

    public DimensionNumber(String string) {
        String[] input = string.split(" ");
        this.number = Double.valueOf(input[0]);
        this.dimension = input[1];
    }

    public double getNumber() {
        return number;
    }

    public String getDimension() {
        return dimension;
    }

    public DimensionNumber sum(DimensionNumber other) {

        Dimension dimension = new Dimension();
        if (this.dimension.equals(other.dimension)) {
            return new DimensionNumber(this.number + other.number, this.dimension);
        } else {
            return new DimensionNumber(this.number +
                    dimension.isCompatible(other.number, other.dimension, this.dimension), this.dimension);
        }
    }

    public DimensionNumber subtract(DimensionNumber other) {

        Dimension dimension = new Dimension();
        if (this.dimension.equals(other.dimension)) {
            return new DimensionNumber(this.number - other.number, this.dimension);
        } else {
            return new DimensionNumber(this.number -
                    dimension.isCompatible(other.number, other.dimension, this.dimension), this.dimension);
        }
    }

    public DimensionNumber multiply(DimensionNumber other) {
        Dimension dimension = new Dimension();
        if (this.dimension.equals(other.dimension)) {
            return new DimensionNumber(this.number * other.number, this.dimension);
        } else {
            return new DimensionNumber(this.number *
                    dimension.isCompatible(other.number, other.dimension, this.dimension), this.dimension);
        }
    }

    public DimensionNumber divide(DimensionNumber other) {

        Dimension dimension = new Dimension();

        if (this.dimension.equals(other.dimension)) {
            return new DimensionNumber(this.number / other.number, this.dimension);
        } else {
            return new DimensionNumber(this.number /
                    dimension.isCompatible(other.number, other.dimension, this.dimension), this.dimension);
        }
    }

    public int compareTo(DimensionNumber other) {
        Dimension dimension = new Dimension();
        if (this.number - dimension.isCompatible(other.number, other.dimension, this.dimension) == 0) {
            return 0;
        }
        else if (this.number - dimension.isCompatible(other.number, other.dimension, this.dimension) > 0) {
            return 1;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return this.number + " " + this.dimension;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DimensionNumber other = (DimensionNumber) obj;
        if (Double.compare(number, other.number) != 0)
            return false;
        if (dimension == null) {
            if (other.dimension != null)
                return false;
        } else if (!dimension.equals(other.dimension))
            return false;
        return true;
    }
}

