package com.ardyhost;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.PluginPanel;
import net.runelite.client.util.ImageUtil;
import net.runelite.client.ui.ClientToolbar;
import java.awt.image.BufferedImage;

@Slf4j
@PluginDescriptor(
	name = "Ardy Host"
)
public class ArdyHostPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private ArdyHostConfig config;

	private NavigationButton navButton;
	private PluginPanel panel;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");

		final BufferedImage icon = ImageUtil.loadImageResource(getClass(), "/FireSurge.png");

		panel = new ArdyHostPanel();

		navButton = NavigationButton.builder()
				.tooltip("Ardy-Host")
				.icon(icon)
				.priority(8)
				.panel(panel)
				.build();

		clientToolbar.addNavigation(navButton);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientToolbar.removeNavigation(navButton);
	}

	@Provides
	ArdyHostConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ArdyHostConfig.class);
	}
}
