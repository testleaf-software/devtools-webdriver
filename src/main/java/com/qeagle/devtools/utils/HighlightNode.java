package com.qeagle.devtools.utils;

import com.qeagle.devtools.protocol.commands.DOM;
import com.qeagle.devtools.protocol.commands.Overlay;
import com.qeagle.devtools.protocol.types.dom.RGBA;
import com.qeagle.devtools.protocol.types.overlay.HighlightConfig;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class HighlightNode {
	
	public static void highlightNode(
			ChromeDevToolsService devToolsService,String selector) {

		// Enable DOM and overlay
		devToolsService.getDOM().enable();
		devToolsService.getOverlay().enable();


		HighlightConfig highlightConfig = new HighlightConfig();

		highlightConfig.setBorderColor(rgba(255, 229, 153, 0.66));
		highlightConfig.setContentColor(rgba(111, 168, 220, 0.66));
		highlightConfig.setCssGridColor(rgb(75, 0, 130));
		highlightConfig.setEventTargetColor(rgba(255, 196, 196, 0.66));
		highlightConfig.setMarginColor(rgba(246, 178, 107, 0.66));
		highlightConfig.setPaddingColor(rgba(147, 196, 125, 0.55));
		highlightConfig.setShapeColor(rgba(96, 82, 117, 0.8));
		highlightConfig.setShapeMarginColor(rgba(96, 82, 127, 0.6));

		highlightConfig.setShowExtensionLines(true);
		highlightConfig.setShowInfo(true);
		highlightConfig.setShowRulers(true);
		highlightConfig.setShowStyles(false);


		final DOM dom = devToolsService.getDOM();
		final Overlay overlay = devToolsService.getOverlay();
		final Integer nodeId =
				dom.querySelector(devToolsService.getDOM().getDocument().getNodeId(), selector);
		overlay.highlightNode(highlightConfig, nodeId, null, null, null);


	}

	public static void clearHighlightNode(
			ChromeDevToolsService devToolsService, String selector) {
		final DOM dom = devToolsService.getDOM();
		final Overlay overlay = devToolsService.getOverlay();
		final Integer nodeId =
				dom.querySelector(devToolsService.getDOM().getDocument().getNodeId(), selector);
		overlay.highlightNode(new HighlightConfig(), nodeId, null, null, null);

	}

	private static RGBA rgba(int r, int g, int b, double a) {
		RGBA result = new RGBA();
		result.setR(r);
		result.setG(g);
		result.setB(b);
		result.setA(a);
		return result;
	}

	private static RGBA rgb(int r, int g, int b) {
		RGBA result = new RGBA();
		result.setR(r);
		result.setG(g);
		result.setB(b);
		return result;
	}

}
