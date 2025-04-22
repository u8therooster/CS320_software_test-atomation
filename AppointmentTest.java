package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class AppointmentTest {

    @Test
    public void testValidAppointmentCreation() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 5);
        Appointment appt = new Appointment("APT001", future.getTime(), "Driver safety inspection.");
        assertEquals("APT001", appt.getAppointmentId());
        assertEquals("Driver safety inspection.", appt.getDescription());
        assertNotNull(appt.getAppointmentDate());
    }

    @Test
    public void testAppointmentIdTooLong() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 3);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT01234567890", future.getTime(), "Too long ID"));
    }

    @Test
    public void testAppointmentIdNull() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 2);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(null, future.getTime(), "Null ID"));
    }

    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT002", null, "Missing date"));
    }

    @Test
    public void testAppointmentDateInPast() {
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -2);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT003", past.getTime(), "Old date"));
    }

    @Test
    public void testAppointmentDescriptionNull() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 4);
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT004", future.getTime(), null));
    }

    @Test
    public void testAppointmentDescriptionTooLong() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 4);
        String longDesc = "This description exceeds the maximum of fifty characters allowed!";
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("APT005", future.getTime(), longDesc));
    }
}
