import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    private DimensionNumber dm1 = new DimensionNumber(2000, "м");
    private DimensionNumber dm2 = new DimensionNumber(2, "км");
    private DimensionNumber dm3 = new DimensionNumber(5300, "с");
    private DimensionNumber dm4 = new DimensionNumber(2, "ч");
    private DimensionNumber dm5 = new DimensionNumber(2, "кг");
    private DimensionNumber dm6 = new DimensionNumber(2000, "гр");
    private DimensionNumber dm7 = new DimensionNumber("2 кг");
    private DimensionNumber dm8 = new DimensionNumber("2000 гр");


    @Test
    public void getNumber() {
        assertEquals(2000, dm1.getNumber(), 1e-5);
        assertEquals(2, dm2.getNumber(), 1e-5);


    }

    @Test
    public void getDimension() {
        assertEquals("м", dm1.getDimension());
        assertEquals("км", dm2.getDimension());

    }

    @Test
    public void sum() {
        assertEquals(new DimensionNumber(4000, "м"), dm1.sum(dm2));
        assertEquals(new DimensionNumber(4, "км"), dm2.sum(dm1));
        assertEquals(new DimensionNumber(12500, "с"), dm3.sum(dm4));
        assertEquals(new DimensionNumber(3.4722222222222223, "ч"), dm4.sum(dm3));
        assertEquals(new DimensionNumber(4, "кг"), dm5.sum(dm6));
        assertEquals(new DimensionNumber(4000, "гр"), dm6.sum(dm5));
        assertEquals(new DimensionNumber(4, "кг"), dm7.sum(dm8));
        assertEquals(new DimensionNumber("4000 гр"), dm8.sum(dm7));
    }

    @Test
    public void subtract() {
        assertEquals(new DimensionNumber(0, "м"), dm1.subtract(dm2));

    }

    @Test
    public void multiply() {
        assertEquals(new DimensionNumber(2.9444444444444446, "ч"), dm4.multiply(dm3));
    }

    @Test
    public void divide() {
        assertEquals(new DimensionNumber("1 кг"), dm7.divide(dm8));
    }


    @Test
    public void compareTo() {
        assertEquals(0, dm1.compareTo(dm2));
        assertEquals(1, dm4.compareTo(dm3));
        assertEquals(-1, dm3.compareTo(dm4));
    }
}
