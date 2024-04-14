package dev.himirai.sampleplugin;

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

public class SamplePluginTest
{

	private ServerMock server;
	private SamplePlugin plugin;
	private PlayerMock player;
	private final String notPassed = "Test `{test}` not passed";

	@BeforeEach
	public void setup()
	{
		server = MockBukkit.mock();
		plugin = MockBukkit.load(SamplePlugin.class);
		server.getLogger().log(Level.INFO, "Server is ready");
	}

	@Test
	public void testLevel() {
		player = server.addPlayer("Himirai");
        assertEquals(100, player.getLevel(), ( ) -> notPassed.replace("{test}", "level"));
		assertFalse(player.getLevel() != 100, () -> notPassed.replace("{test}", "level"));
		server.getLogger().log(Level.INFO, "All tests passed!");
		player.disconnect();
	}

	@AfterEach
	public void teardown() {
		MockBukkit.unmock();
		server.getLogger().log(Level.INFO, "Server closed");
	}

}
