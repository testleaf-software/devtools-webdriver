package com.qeagle.devtools.utils;

import java.util.Arrays;
import java.util.List;

import com.qeagle.devtools.protocol.commands.Network;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class BlockURLs {

	public static void blockGivenURLs(ChromeDevToolsService devToolsService, List<String> blockList) {

		// Get the network and enable
		Network network = devToolsService.getNetwork();
		network.enable();

		// Block some urls.
		network.setBlockedURLs(blockList);
	}
	
	public static void unblockURLs(ChromeDevToolsService devToolsService) {

		// Get the network and enable
		Network network = devToolsService.getNetwork();
		network.enable();

		// Block some urls.
		network.setBlockedURLs(null);
		
		network.disable();
	}
	

}
