package com.qeagle.devtools.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import com.qeagle.devtools.protocol.commands.Emulation;
import com.qeagle.devtools.protocol.types.page.CaptureScreenshotFormat;
import com.qeagle.devtools.protocol.types.page.LayoutMetrics;
import com.qeagle.devtools.protocol.types.page.Viewport;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class FullScreenshot {
	
	public static void captureFullPageScreenshot(
			ChromeDevToolsService devToolsService, String outputFilename) {
		final LayoutMetrics layoutMetrics = devToolsService.getPage().getLayoutMetrics();

		final double width = layoutMetrics.getContentSize().getWidth();
		final double height = layoutMetrics.getContentSize().getHeight();

		final Emulation emulation = devToolsService.getEmulation();
		emulation.setDeviceMetricsOverride(
				Double.valueOf(width).intValue(), Double.valueOf(height).intValue(), 1.0d, Boolean.FALSE);

		Viewport viewport = new Viewport();
		viewport.setScale(1d);

		// You can set offset with X, Y
		viewport.setX(0d);
		viewport.setY(0d);

		// Set a width, height of a page to take screenshot at
		viewport.setWidth(width);
		viewport.setHeight(height);

		storeAsFile(
				outputFilename,
				devToolsService.getPage().captureScreenshot(CaptureScreenshotFormat.PNG, 100, viewport, Boolean.TRUE));
	}

	
	private static void storeAsFile(String fileName, String data) {
		FileOutputStream fileOutputStream = null;
		try {
			File file = new File(fileName);
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(Base64.getDecoder().decode(data));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileOutputStream != null) {
				try {
					fileOutputStream.flush();
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
