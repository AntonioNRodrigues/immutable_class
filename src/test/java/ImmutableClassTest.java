import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ImmutableClassTest {

    @Test
    void constructorShouldInitializeFields() {
        Address address = new Address("123 Main St", "Springfield");
        ImmutableClass immutableClass = new ImmutableClass("John Doe", 30, address);
        assertEquals("John Doe", immutableClass.getName());
        assertEquals(30, immutableClass.getAge());
        Assertions.assertEquals(address.getCity(), immutableClass.getAddress().getCity());
        Assertions.assertEquals(address.getStreet(), immutableClass.getAddress().getStreet());
        assertEquals(address, immutableClass.getAddress());
    }

    @Test
    void getAddressShouldReturnDefensiveCopy() {
        Address address = new Address("123 Main St", "Springfield");
        ImmutableClass immutableClass = new ImmutableClass("John Doe", 30, address);
        Address returnedAddress = immutableClass.getAddress();
        assertNotSame(address, returnedAddress);
        // since the Address class is mutable, we need to make sure that the Address object is not the same object
        assertEquals(address, returnedAddress);
    }

    @Test
    void equalsShouldReturnTrueForEqualObjects() {
        Address address1 = new Address("123 Main St", "Springfield");
        Address address2 = new Address("123 Main St", "Springfield");
        ImmutableClass obj1 = new ImmutableClass("John Doe", 30, address1);
        ImmutableClass obj2 = new ImmutableClass("John Doe", 30, address2);
        assertEquals(obj1, obj2);
    }

    @Test
    void equalsShouldReturnFalseForDifferentObjects() {
        Address address1 = new Address("123 Main St", "Springfield");
        Address address2 = new Address("456 Elm St", "Shelbyville");
        ImmutableClass obj1 = new ImmutableClass("John Doe", 30, address1);
        ImmutableClass obj2 = new ImmutableClass("Jane Doe", 25, address2);
        assertNotEquals(obj1, obj2);
    }

    @Test
    void hashCodeShouldBeConsistentWithEquals() {
        Address address1 = new Address("123 Main St", "Springfield");
        Address address2 = new Address("123 Main St", "Springfield");
        ImmutableClass obj1 = new ImmutableClass("John Doe", 30, address1);
        ImmutableClass obj2 = new ImmutableClass("John Doe", 30, address2);
        assertEquals(obj1.hashCode(), obj2.hashCode());
    }

    @Test
    void toStringShouldReturnFormattedString() {
        Address address = new Address("123 Main St", "Springfield");
        ImmutableClass immutableClass = new ImmutableClass("John Doe", 30, address);
        String expected = "ImmutableClass{name='John Doe', age=30, address=Address{street='123 Main St', city='Springfield'}}";
        assertEquals(expected, immutableClass.toString());
    }
}