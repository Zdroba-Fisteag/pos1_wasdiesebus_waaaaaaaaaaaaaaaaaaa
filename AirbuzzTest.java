

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AirbuzzTest.
 *
 * @author  (Wer auch immer sich das anschaut)
 * @version (1)
 */
public class AirbuzzTest
{
    public AirbuzzTest()
    {
        try {
            Airbuzz A380 = new Airbuzz();
            Person Noah = new Person("Noah", true, 1.76, 69);
            Airbuzz.board(Noah);
        }
        catch (Exception e) {
            System.out.println("Exception gefangen: " + e.getMessage());
        }
    }

    @BeforeEach
    public void setUp()
    {
        
    }

    @AfterEach
    public void tearDown()
    {
        
    }
}