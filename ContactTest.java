package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("CNT100", "Lena", "Swift", "8035559023", "145 Dragline Blvd");
        assertEquals("CNT100", contact.getContactId());
        assertEquals("Lena", contact.getFirstName());
        assertEquals("Swift", contact.getLastName());
        assertEquals("8035559023", contact.getPhone());
        assertEquals("145 Dragline Blvd", contact.getAddress());
    }

    // Contact ID Tests
    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact(null, "Max", "Boost", "5555555555", "500 Turbo St"));
    }

    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("TOOLONGID123", "Max", "Boost", "5555555555", "500 Turbo St"));
    }

    // First Name Tests
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT101", null, "Boost", "5555555555", "500 Turbo St"));
    }

    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT102", "Superlongfirstname", "Boost", "5555555555", "500 Turbo St"));
    }

    @Test
    public void testSetFirstNameInvalid() {
        Contact contact = new Contact("CNT103", "Max", "Boost", "5555555555", "500 Turbo St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Extralongnamehere"));
    }

    // Last Name Tests
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT104", "Max", null, "5555555555", "500 Turbo St"));
    }

    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT105", "Max", "ExtraLongLastName", "5555555555", "500 Turbo St"));
    }

    @Test
    public void testSetLastNameInvalid() {
        Contact contact = new Contact("CNT106", "Max", "Boost", "5555555555", "500 Turbo St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("LastnameIsWayTooLong"));
    }

    // Phone Number Tests
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT107", "Max", "Boost", null, "500 Turbo St"));
    }

    @Test
    public void testPhoneInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT108", "Max", "Boost", "55555", "500 Turbo St"));

        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT109", "Max", "Boost", "1234567890123", "500 Turbo St"));
    }

    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("CNT110", "Max", "Boost", "5555555555", "500 Turbo St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("1234"));
    }

    // Address Tests
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT111", "Max", "Boost", "5555555555", null));
    }

    @Test
    public void testAddressTooLong() {
        String longAddress = "This is a super long garage address exceeding the limit.";
        assertThrows(IllegalArgumentException.class, () -> 
            new Contact("CNT112", "Max", "Boost", "5555555555", longAddress));
    }

    @Test
    public void testSetAddressInvalid() {
        Contact contact = new Contact("CNT113", "Max", "Boost", "5555555555", "500 Turbo St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class, () ->
            contact.setAddress("This is a pit lane address that goes way beyond 30 characters."));
    }
}
