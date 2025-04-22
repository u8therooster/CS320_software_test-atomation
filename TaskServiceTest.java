package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    private TaskService service;

    @BeforeEach
    public void setup() {
        service = new TaskService();
    }

    @Test
    public void testAddAndRetrieveTask() {
        Task task = new Task("TSK10", "Track Setup", "Setup cones and timing lights at drag strip.");
        service.addTask(task);
        Task retrieved = service.getTaskById("TSK10");
        assertNotNull(retrieved);
        assertEquals("Track Setup", retrieved.getName());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("TSK20", "Fuel Mix", "Mix race fuel for maximum performance.");
        service.addTask(task);
        service.deleteTask("TSK20");
        assertNull(service.getTaskById("TSK20"));
    }

    @Test
    public void testUpdateFields() {
        Task task = new Task("TSK30", "Tire Pressure", "Check and adjust tire pressure.");
        service.addTask(task);
        service.updateName("TSK30", "Tire Adjust");
        service.updateDescription("TSK30", "Ensure optimal tire grip before race.");
        Task updated = service.getTaskById("TSK30");
        assertEquals("Tire Adjust", updated.getName());
        assertEquals("Ensure optimal tire grip before race.", updated.getDescription());
    }

    @Test
    public void testDuplicateIdNotAllowed() {
        Task task1 = new Task("TSK99", "Helmet Check", "Verify driver helmet safety compliance.");
        Task task2 = new Task("TSK99", "Harness Check", "Inspect safety harness integrity.");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }
}
