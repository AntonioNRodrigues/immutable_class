import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void constructorShouldInitializeFields() {
        Address address = new Address("123 Main St", "Springfield");
        assertEquals("123 Main St", address.getStreet());
        assertEquals("Springfield", address.getCity());
    }

    @Test
    void copyConstructorShouldCreateDefensiveCopy() {
        Address original = new Address("123 Main St", "Springfield");
        Address copy = new Address(original);
        assertEquals("123 Main St", copy.getStreet());
        assertEquals("Springfield", copy.getCity());
        assertNotSame(original, copy);
    }

    @Test
    void setStreetShouldUpdateStreet() {
        Address address = new Address("123 Main St", "Springfield");
        address.setStreet("456 Elm St");
        assertEquals("456 Elm St", address.getStreet());
    }

    @Test
    void setCityShouldUpdateCity() {
        Address address = new Address("123 Main St", "Springfield");
        address.setCity("Shelbyville");
        assertEquals("Shelbyville", address.getCity());
    }

    @Test
    void toStringShouldReturnFormattedString() {
        Address address = new Address("123 Main St", "Springfield");
        String expected = "Address{street='123 Main St', city='Springfield'}";
        assertEquals(expected, address.toString());
    }
}