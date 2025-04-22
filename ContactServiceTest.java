package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContactAndRetrieve() {
        Contact contact = new Contact("RACER42", "Nova", "Nitro", "7013334455", "42 Quarter Mile Blvd");
        contactService.addContact(contact);

        Contact retrieved = contactService.getContactById("RACER42");
        assertNotNull(retrieved);
        assertEquals("Nova", retrieved.getFirstName());
        assertEquals("Nitro", retrieved.getLastName());
    }

    @Test
    public void testDeleteContactById() {
        Contact contact = new Contact("TEAM11", "Axel", "Boost", "7739992211", "11 Apex Garage St");
        contactService.addContact(contact);
        contactService.deleteContact("TEAM11");

        assertNull(contactService.getContactById("TEAM11"));
    }

    @Test
    public void testUpdateContactFields() {
        Contact contact = new Contact("TORQ77", "Vega", "Drift", "3105557821", "77 Pit Row");
        contactService.addContact(contact);

        contactService.updateFirstName("TORQ77", "Vee");
        contactService.updateLastName("TORQ77", "Slide");
        contactService.updatePhone("TORQ77", "3109991111");
        contactService.updateAddress("TORQ77", "77 Engine Lane");

        Contact updated = contactService.getContactById("TORQ77");
        assertEquals("Vee", updated.getFirstName());
        assertEquals("Slide", updated.getLastName());
        assertEquals("3109991111", updated.getPhone());
        assertEquals("77 Engine Lane", updated.getAddress());
    }

    @Test
    public void testDuplicateContactIdThrowsException() {
        Contact contact1 = new Contact("BOOST88", "Sky", "Torque", "8887776633", "88 Rapid Shift Ave");
        Contact contact2 = new Contact("BOOST88", "Dash", "Nitrix", "8885554411", "88 Rapid Shift Ave");

        contactService.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> contactService.addContact(contact2));
    }
}
