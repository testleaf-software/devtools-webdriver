package com.qeagle.devtools.utils;

import org.openqa.selenium.By;

import com.qeagle.devtools.protocol.commands.LayerTree;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class LayerChange {

	public static LayerTree enableLayers(ChromeDevToolsService devToolsService) {
		LayerTree layers = devToolsService.getLayerTree();
		layers.enable();
		return layers;
	}

	public static void waitUntilLayerChanged(LayerTree layers) {
		layers.onLayerTreeDidChange(
				event -> {
					System.out.println("Waiting ... ");
				});
		waitForThreadsToComplete();
		System.out.println("Done");
	}


	private static void waitForThreadsToComplete() {
		try {
			boolean bRunning = true;
			Thread.sleep(500);
			int runningThreads = Thread.getAllStackTraces().keySet().size();

			while(bRunning) {
				if(runningThreads > Thread.getAllStackTraces().keySet().size())
					bRunning = false;
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static LayerTree disableLayers(ChromeDevToolsService devToolsService) {
		LayerTree layers = null;
		try {
			layers = devToolsService.getLayerTree();
			layers.disable();
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		return layers;
	}

}
