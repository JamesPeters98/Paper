package org.bukkit.event;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.junit.jupiter.api.Test;

public class InventoryMoveItemEventTest {

    @Test
    public void testSkipItem() {
        InventoryMoveItemEvent event = newEvent();
        event.skipItem();
        assertTrue(event.isCancelled());
        assertTrue(event.isItemSkipped());
    }

    @Test
    public void testCancelOverridesSkip() {
        InventoryMoveItemEvent event = newEvent();
        event.skipItem();
        event.setCancelled(true);
        assertTrue(event.isCancelled());
        assertFalse(event.isItemSkipped());
    }

    @Test
    public void testUncancelClearsSkip() {
        InventoryMoveItemEvent event = newEvent();
        event.skipItem();
        event.setCancelled(false);
        assertFalse(event.isCancelled());
        assertFalse(event.isItemSkipped());
    }

    private InventoryMoveItemEvent newEvent() {
        return new InventoryMoveItemEvent(mock(), mock(), mock(), false);
    }
}
