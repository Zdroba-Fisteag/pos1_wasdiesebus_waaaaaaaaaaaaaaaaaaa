import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest
{
    /**
     * Default constructor for test class PersonTest
     */
    public PersonTest()
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
        Person ferdi = new Person("Ferdinand", true, 181, 100);
        assertEquals("Übergewicht", ferdi.bmiWerter(), "BMI Wertung"); //Korrekt
        System.out.println(ferdi);
        //assertEquals("Übergewichtung", ferdi.bmiWerter(), "BMI Wertung"); //Error
        Person mann_unter = new Person("MannUnter", true, 200, 65);
        assertEquals("Untergewicht", mann_unter.bmiWerter(), "BMI Wertung");
        Person mann_normal = new Person("MannNormal", true, 180, 80);
        assertEquals("Normal", mann_normal.bmiWerter(), "BMI Wertung");
        // Frau
        Person frau_uber = new Person("FrauUber", false, 160, 100);
        assertEquals("Übergewicht", frau_uber.bmiWerter(), "BMI Wertung");
        Person frau_unter = new Person("FrauUnter", false, 200, 65);
        assertEquals("Untergewicht", frau_unter.bmiWerter(), "BMI Wertung");
        Person frau_normal = new Person("FrauNormal", false, 160, 55);
        assertEquals("Normal", frau_normal.bmiWerter(), "BMI Wertung");
    }
    
    @Test
    public void Test_BMI_annaherung(){
        // Test ist um 0.100...1 off
        Person test = new Person("Test", true, 180, 69.67); //69.66 für error
        assertEquals(21.6, test.bmiRechner(), 0.1, "Erwartet ist 21.6");
        
        Person test2 = new Person("Test2", false, 200, 73.6000001); //73.6 für error
        assertEquals(18.5, test2.bmiRechner(), 0.1, "Erwartet ist 18.5");
        
        Person test3 = new Person("Test3", false, 180, 86.8); //86.9 für error
        assertEquals(26.7, test3.bmiRechner(), 0.1, "Erwartet ist 26.7");
    }
    
    @Test 
    public void testFalscherNameThrows(){
        Person stud;
        try {
            stud = new Person("FE", true, 180, 80); // Excpetion erwartet
        }
        catch (Exception e) {
            System.out.println("Exception gefangen: " + e.getMessage());
        }
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