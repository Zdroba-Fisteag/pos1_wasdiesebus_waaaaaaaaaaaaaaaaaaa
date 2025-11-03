import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        System.out.println("Executing SetUp()");
    }
    
        @Test
    public void Test_BMI(){
        //Mann
        Student ferdi = new Student("Ferdinand", true, 181, 100);
        assertEquals("Übergewicht", ferdi.bmi_werter(), "BMI Wertung"); //Korrekt
        //assertEquals("Übergewichtung", ferdi.bmi_werter(), "BMI Wertung"); //Error
        Student mann_unter = new Student("MannUnter", true, 200, 65);
        assertEquals("Untergewicht", mann_unter.bmi_werter(), "BMI Wertung");
        Student mann_normal = new Student("MannNormal", true, 180, 80);
        assertEquals("Normal", mann_normal.bmi_werter(), "BMI Wertung");
        // Frau
        Student frau_uber = new Student("FrauUber", false, 160, 100);
        assertEquals("Übergewicht", frau_uber.bmi_werter(), "BMI Wertung");
        Student frau_unter = new Student("FrauUnter", false, 200, 65);
        assertEquals("Untergewicht", frau_unter.bmi_werter(), "BMI Wertung");
        Student frau_normal = new Student("FrauNormal", false, 160, 55);
        assertEquals("Normal", frau_normal.bmi_werter(), "BMI Wertung");
    }
    
    @Test
    public void Test_BMI_annaherung(){
        // Test ist um 0.100...1 off
        Student test = new Student("Test", true, 180, 69.67); //69.66 für error
        assertEquals(21.6, test.bmi_rechner(), 0.1, "Erwartet ist 21.6");
        
        Student test2 = new Student("Test2", false, 200, 73.6000001); //73.6 für error
        assertEquals(18.5, test2.bmi_rechner(), 0.1, "Erwartet ist 18.5");
        
        Student test3 = new Student("Test3", false, 180, 86.8); //86.9 für error
        assertEquals(26.7, test3.bmi_rechner(), 0.1, "Erwartet ist 26.7");
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("Executing TearDown()");
    }
}