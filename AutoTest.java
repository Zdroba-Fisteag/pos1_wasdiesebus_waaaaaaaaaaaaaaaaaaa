import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoTest
{
    /**
     * Default constructor for test class AutoTest
     */
    public AutoTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    // In setup personen und Autos erstellen 
    public void setUp()
    {
        System.out.println("Executing SetUp()");
    }
    
    @Test
    public void TestGesamtGewichtAuto(){
        try {
        Auto BMW = new Auto("BMW", 3000);
        Person ferdi = new Person("Ferdinand", true, 181, 200); //Fahrer
        BMW.einsteigen(ferdi);
        Person marie = new Person("Marie", false, 160, 200); //Beifahrerin
        BMW.einsteigen(marie);
        Person hans = new Person("Hans", true, 170, 200); //Rückbank
        BMW.einsteigen(hans);
        BMW.autoAushalten();
    } 
    catch (Exception e){
        System.out.println("Exception gefangen: " + e.getMessage());
    }   
    }
    
    @Test
    public void TestAuto(){
        // Autoname null Test
        try{
            Auto Audi = new Auto(null, 2000);
        }
        catch (Exception n){
            System.out.println("Exception gefange: " + n.getMessage());
        }
        // Auto Eigengewicht mehr als 3000 Test
        try {
            Auto Ford = new Auto("Ford", 3001);
        }
        catch (Exception k){
            System.out.println("Exception gefangen: " + k.getMessage());
        }
        // Aussteige Funktion Test
        try {
            Auto Skoda = new Auto("Skoda", 1500);
            Person Jakob = new Person("Jakob", true, 180, 80);
            Skoda.einsteigen(Jakob);
            Skoda.aussteigen("Bob"); //String Version
        }
        catch (Exception p){
            System.out.println("Exception gefangen: " + p.getMessage());
        }
        // Person nicht null Test
        try {
            Auto Porsche = new Auto("Porsche", 1870);
            Person Bob = null;
            Porsche.einsteigen(Bob);
        }
        catch (Exception t){
            System.out.println("Exception gefangen: " + t.getMessage());
        }
        
        // 2 gleiche Personen im Auto
        try {
            Auto Test = new Auto("Test", 2000);
            Person Jakob = new Person("Jakob", true, 180, 80);
            Test.einsteigen(Jakob);
            Test.einsteigen(Jakob);
        }
        catch (Exception z){
            System.out.println("Exception gefangen: " + z.getMessage());
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
        System.out.println("Executing tearUp()");
    }
}