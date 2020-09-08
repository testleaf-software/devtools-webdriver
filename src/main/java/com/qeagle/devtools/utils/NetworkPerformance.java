package com.qeagle.devtools.utils;

import java.util.List;

import com.qeagle.devtools.protocol.commands.Network;
import com.qeagle.devtools.protocol.commands.Performance;
import com.qeagle.devtools.protocol.types.performance.Metric;
import com.qeagle.devtools.services.ChromeDevToolsService;

public class NetworkPerformance {

	public static Performance enablePerformance(ChromeDevToolsService devToolsService) {
		Performance performance = devToolsService.getPerformance();
		performance.enable();
		return performance;
	}


	public static Performance disablePerformance(ChromeDevToolsService devToolsService) {
		Performance performance = devToolsService.getPerformance();
		performance.disable();
		return performance;
	}

	public static void getPerformanceMetrics(ChromeDevToolsService devToolsService) {

		Network network = devToolsService.getNetwork();
		Performance performance = enablePerformance(devToolsService);

		network.onLoadingFinished(
				event -> {
					List<Metric> metrics = performance.getMetrics();
					try {
						for (Metric metric : metrics) {
							System.out.println(metric.getName() + ": " + metric.getValue());
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

				});
		
		network.enable();
	}

}
