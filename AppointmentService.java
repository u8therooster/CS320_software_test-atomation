package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointmentMap = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointmentMap.remove(appointmentId);
    }

    public Appointment getAppointmentById(String appointmentId) {
        return appointmentMap.get(appointmentId);
    }
}
