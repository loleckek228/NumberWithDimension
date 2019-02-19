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
        this.dimension =input[1];
    }

    public double getNumber() {
        return number;
    }

    public String getDimension(){
        return dimension;
    }

    public DimensionNumber sum(DimensionNumber other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Размерности не совпадают");
        return new DimensionNumber(this.number + other.number, this.dimension);
    }

    public DimensionNumber subtract(DimensionNumber other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Размерности не совпадают");
        return new DimensionNumber(this.number - other.number, this.dimension);
    }

    public DimensionNumber multiply(double factor) {
        return new DimensionNumber(this.number * factor, this.dimension);
    }

    public DimensionNumber divide(double divisor) {
        return new DimensionNumber(this.number / divisor, this.dimension);
    }

    public DimensionNumber divideWithDim(DimensionNumber other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Размерности не совпадают");
        return new DimensionNumber(this.number / other.number, this.dimension);
    }

    public int compareTo(DimensionNumber other) {
        if (!this.dimension.equals(other.dimension))
            throw new IllegalArgumentException("Размерности не совпадают");
        return Double.compare(this.number, other.number);
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
