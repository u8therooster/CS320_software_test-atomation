package appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class AppointmentServiceTest {

    private AppointmentService service;

    @BeforeEach
    public void setup() {
        service = new AppointmentService();
    }

    @Test
    public void testAddAndRetrieveAppointment() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 7);
        Appointment appt = new Appointment("RACE100", future.getTime(), "Pre-race alignment check.");
        service.addAppointment(appt);
        assertEquals("RACE100", service.getAppointmentById("RACE100").getAppointmentId());
    }

    @Test
    public void testDeleteAppointment() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 10);
        Appointment appt = new Appointment("RACE200", future.getTime(), "Sponsor meeting.");
        service.addAppointment(appt);
        service.deleteAppointment("RACE200");
        assertNull(service.getAppointmentById("RACE200"));
    }

    @Test
    public void testDuplicateAppointmentIdThrowsException() {
        Calendar future = Calendar.getInstance();
        future.add(Calendar.DATE, 15);
        Appointment appt1 = new Appointment("RACE300", future.getTime(), "Team strategy briefing.");
        Appointment appt2 = new Appointment("RACE300", future.getTime(), "Media day appearance.");
        service.addAppointment(appt1);
        assertThrows(IllegalArgumentException.class, () -> service.addAppointment(appt2));
    }
    @Test
    public void testDeleteNonexistentAppointmentThrows() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteAppointment("DOESNOTEXIST"));
    }
}
