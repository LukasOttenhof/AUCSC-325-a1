import com.example.Demo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 *
 * This code was written on a mac and may not work 100% on a windows machine.
 *
 * >> Line Coverage (for mutated classes only): 16/16 (100%)
 * >> Generated 33 mutations Killed 30 (91%)
 * >> Mutations with no coverage 0. Test strength 91%
 * >> Ran 53 tests (1.61 tests per mutation)
 *
 * The final 3 mutations were not able to be killed because 2 of them
 * involve changing the boundary of the if statement that determines
 * if the sides make a triangle. If the boundary is changed the incorrect
 * answer will always be returned because changing that breaks the rule
 * of what a triangle is.
 *
 * The last mutation that could not be killed is the remove call to the close
 * scanner line. This mutation will not pass because the scanner needs to
 * be closed.
 *
 */

public class DemoTest {
    // test demo class not null when made
    @Test
    public void testDemoClassInstantiation() {
        Demo demo = new Demo(); // This ensures line coverage for the constructor
        Assertions.assertNotNull(demo); // Optional check to confirm object creation
    }
    // Test for a triangle with one large side
    @Test
    public void testIsTriangleFalse() {
        Assertions.assertFalse(Demo.isTriangle(100, 5, 5));
        Assertions.assertFalse(Demo.isTriangle(5, 100, 5));
        Assertions.assertFalse(Demo.isTriangle(5, 5, 100));
    }

    // Test for an equilateral triangle
    @Test
    public void testIsTriangleTrueEqualSides() {
        Assertions.assertTrue(Demo.isTriangle(5, 5, 5));
    }

    // Test for a valid scalene triangle
    @Test
    public void testIsTriangleTrueScalene() {
        Assertions.assertTrue(Demo.isTriangle(3, 4, 5));
    }

    // Test for a case where two sides sum exactly to the third (not a triangle)
    @Test
    public void testIsTriangleFalseExactSum() {
        Assertions.assertFalse(Demo.isTriangle(1, 2, 3));
        Assertions.assertFalse(Demo.isTriangle(2, 3, 5));
    }

    // Test for a triangle with one zero or negative side (not a triangle)
    @Test
    public void testIsTriangleFalseWithZero() {
        Assertions.assertFalse(Demo.isTriangle(0, 5, 5));   // One side is zero
    }

    // Test for a triangle with a negative num
    @Test
    public void  testIsTriangleFalseWithNegative(){
        Assertions.assertFalse(Demo.isTriangle(3, -3, 3));  // Negative side
    }

    // Test for main with valid triangle input
    @Test
    public void testMainIsTriangle() {
        String sides = "5\n5\n5\n";
        String result = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is a triangle.\n";

        ByteArrayInputStream input = new ByteArrayInputStream(sides.getBytes());
        System.setIn(input);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Demo.main(new String[]{});

        Assertions.assertEquals(result, outContent.toString());
    }

    // Test for main with invalid triangle input
    @Test
    public void testMainIsntTriangle() {
        String sides = "5\n100\n5\n";
        String result = "Enter side 1: \nEnter side 2: \nEnter side 3: \nThis is not a triangle.\n";

        ByteArrayInputStream input = new ByteArrayInputStream(sides.getBytes());
        System.setIn(input);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Demo.main(new String[]{});

        Assertions.assertEquals(result, outContent.toString());
    }
}
