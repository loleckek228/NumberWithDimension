import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    private DimensionNumber dm1 = new DimensionNumber(2000, "м");
    private DimensionNumber dm2 = new DimensionNumber(234.4837, "кг");
    private DimensionNumber dm3 = new DimensionNumber(485.926, "с");
    private DimensionNumber dm4 = new DimensionNumber(83.987, "кг*м/с");
    private DimensionNumber dm5 = new DimensionNumber("927.837 м");
    private DimensionNumber dm6 = new DimensionNumber("2.38 кг");
    private DimensionNumber dm7 = new DimensionNumber("48 с");
    private DimensionNumber dm8 = new DimensionNumber(83.987, "кг*м/с");

    @Test
    public void getNumber() {
        assertEquals(2000, dm1.getNumber(), 1e-5);
        assertEquals(234.4837, dm2.getNumber(), 1e-5);
        assertEquals(485.926, dm3.getNumber(), 1e-5);
        assertEquals(83.987, dm4.getNumber(), 1e-5);
        assertEquals(927.837, dm5.getNumber(), 1e-5);
        assertEquals(2.38, dm6.getNumber(), 1e-5);
        assertEquals(48, dm7.getNumber(), 1e-5);


    }

    @Test
    public void getDimension() {
        assertEquals("м", dm1.getDimension());
        assertEquals("кг", dm2.getDimension());
        assertEquals("с", dm3.getDimension());
        assertEquals("кг*м/с", dm4.getDimension());
        assertEquals("м", dm5.getDimension());
        assertEquals("кг", dm6.getDimension());
        assertEquals("с", dm7.getDimension());
    }

    @Test
    public void sum() {
        assertEquals(new DimensionNumber(2927.837, "м"), dm1.sum(dm5));
    }

    @Test
    public void subtract() {
        assertEquals(new DimensionNumber(232.1037, "кг"), dm2.subtract(dm6));

    }

    @Test
    public void multiply() {
        assertEquals(new DimensionNumber(485926, "с"), dm3.multiply(1000));
    }

    @Test
    public void divide() {
        assertEquals(new DimensionNumber(6, "с"), dm7.divide(8));
    }

    @Test
    public void divideWithDim() {
        assertEquals(new DimensionNumber(98.52256302521009, "кг"), dm2.divideWithDim(dm6));

    }

    @Test
    public void compareTo() {
        assertEquals(1, dm1.compareTo(dm5));
        assertEquals(0, dm4.compareTo(dm8));
        assertEquals(-1, dm5.compareTo(dm1));

    }




}
