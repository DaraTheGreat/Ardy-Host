package com.ardyhost;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("example")
public interface ArdyHostConfig extends Config
{

	@ConfigItem(
			position = 1,
			keyName = "quaid",
			name = "quaids stupid",
			description = "when i hover of this quaid sucks elephants"
	)
	default boolean quaid() { return true; }

	enum SortType
	{
		AMOUNT,
		NAME,
		DATE,
	}

	@ConfigItem(
			position = 2,
			keyName = "donosort",
			name = "Sort by:",
			description = "Choose how to sort the list of donations"
	)
	default SortType donosort() {return SortType.NAME; }

}
