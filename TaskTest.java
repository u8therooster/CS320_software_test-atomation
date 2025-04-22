package task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("TSK01", "Turbo Flush", "Flush and clean turbo lines before race.");
        assertEquals("TSK01", task.getTaskId());
        assertEquals("Turbo Flush", task.getName());
        assertEquals("Flush and clean turbo lines before race.", task.getDescription());
    }

    @Test
    public void testNullFields() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Fuel Load", "Fill tank with race blend fuel"));
        assertThrows(IllegalArgumentException.class, () -> new Task("TSK02", null, "Fill tank with race blend fuel"));
        assertThrows(IllegalArgumentException.class, () -> new Task("TSK02", "Fuel Load", null));
    }

    @Test
    public void testFieldLengthLimits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("TASKIDTOOLONG123", "Nitro Tune", "Adjust fuel mapping for nitro use")); // ID > 10

        assertThrows(IllegalArgumentException.class, () ->
            new Task("TSK03", "OverlyLongTaskNameThatExceedsTwentyCharacters", "Adjust fuel mapping")); // Name > 20

        assertThrows(IllegalArgumentException.class, () ->
            new Task("TSK04", "Nitro Tune", 
                "This description is way too long and clearly exceeds the fifty characters limit for task descriptions.")); // Description > 50
    }

    @Test
    public void testSettersValidation() {
        Task task = new Task("TSK05", "Tire Check", "Verify tire wear and pressure levels.");

        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
        assertThrows(IllegalArgumentException.class, () -> task.setName("WayTooLongTaskNameThatBreaksTheRule"));

        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(
            "Extremely long description that pushes the boundary past what is allowed in the task rules."));
    }
}

