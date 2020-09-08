package com.qeagle.devtools.protocol;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2019 TL
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.qeagle.devtools.protocol.commands.Accessibility;
import com.qeagle.devtools.protocol.commands.Animation;
import com.qeagle.devtools.protocol.commands.ApplicationCache;
import com.qeagle.devtools.protocol.commands.Audits;
import com.qeagle.devtools.protocol.commands.BackgroundService;
import com.qeagle.devtools.protocol.commands.Browser;
import com.qeagle.devtools.protocol.commands.CSS;
import com.qeagle.devtools.protocol.commands.CacheStorage;
import com.qeagle.devtools.protocol.commands.Cast;
import com.qeagle.devtools.protocol.commands.Console;
import com.qeagle.devtools.protocol.commands.DOM;
import com.qeagle.devtools.protocol.commands.DOMDebugger;
import com.qeagle.devtools.protocol.commands.DOMSnapshot;
import com.qeagle.devtools.protocol.commands.DOMStorage;
import com.qeagle.devtools.protocol.commands.Database;
import com.qeagle.devtools.protocol.commands.Debugger;
import com.qeagle.devtools.protocol.commands.DeviceOrientation;
import com.qeagle.devtools.protocol.commands.Emulation;
import com.qeagle.devtools.protocol.commands.Fetch;
import com.qeagle.devtools.protocol.commands.HeadlessExperimental;
import com.qeagle.devtools.protocol.commands.HeapProfiler;
import com.qeagle.devtools.protocol.commands.IO;
import com.qeagle.devtools.protocol.commands.IndexedDB;
import com.qeagle.devtools.protocol.commands.Input;
import com.qeagle.devtools.protocol.commands.Inspector;
import com.qeagle.devtools.protocol.commands.LayerTree;
import com.qeagle.devtools.protocol.commands.Log;
import com.qeagle.devtools.protocol.commands.Media;
import com.qeagle.devtools.protocol.commands.Memory;
import com.qeagle.devtools.protocol.commands.Network;
import com.qeagle.devtools.protocol.commands.Overlay;
import com.qeagle.devtools.protocol.commands.Page;
import com.qeagle.devtools.protocol.commands.Performance;
import com.qeagle.devtools.protocol.commands.Profiler;
import com.qeagle.devtools.protocol.commands.Runtime;
import com.qeagle.devtools.protocol.commands.Schema;
import com.qeagle.devtools.protocol.commands.Security;
import com.qeagle.devtools.protocol.commands.ServiceWorker;
import com.qeagle.devtools.protocol.commands.Storage;
import com.qeagle.devtools.protocol.commands.SystemInfo;
import com.qeagle.devtools.protocol.commands.Target;
import com.qeagle.devtools.protocol.commands.Tethering;
import com.qeagle.devtools.protocol.commands.Tracing;
import com.qeagle.devtools.protocol.commands.WebAudio;
import com.qeagle.devtools.protocol.commands.WebAuthn;

public interface ChromeDevTools {

  /** Returns the Console command. */
  Console getConsole();

  /** Returns the Debugger command. */
  Debugger getDebugger();

  /** Returns the HeapProfiler command. */
  HeapProfiler getHeapProfiler();

  /** Returns the Profiler command. */
  Profiler getProfiler();

  /** Returns the Runtime command. */
  Runtime getRuntime();

  /** Returns the Schema command. */
  Schema getSchema();

  /** Returns the Accessibility command. */
  Accessibility getAccessibility();

  /** Returns the Animation command. */
  Animation getAnimation();

  /** Returns the ApplicationCache command. */
  ApplicationCache getApplicationCache();

  /** Returns the Audits command. */
  Audits getAudits();

  /** Returns the BackgroundService command. */
  BackgroundService getBackgroundService();

  /** Returns the Browser command. */
  Browser getBrowser();

  /** Returns the CSS command. */
  CSS getCSS();

  /** Returns the CacheStorage command. */
  CacheStorage getCacheStorage();

  /** Returns the Cast command. */
  Cast getCast();

  /** Returns the DOM command. */
  DOM getDOM();

  /** Returns the DOMDebugger command. */
  DOMDebugger getDOMDebugger();

  /** Returns the DOMSnapshot command. */
  DOMSnapshot getDOMSnapshot();

  /** Returns the DOMStorage command. */
  DOMStorage getDOMStorage();

  /** Returns the Database command. */
  Database getDatabase();

  /** Returns the DeviceOrientation command. */
  DeviceOrientation getDeviceOrientation();

  /** Returns the Emulation command. */
  Emulation getEmulation();

  /** Returns the HeadlessExperimental command. */
  HeadlessExperimental getHeadlessExperimental();

  /** Returns the IO command. */
  IO getIO();

  /** Returns the IndexedDB command. */
  IndexedDB getIndexedDB();

  /** Returns the Input command. */
  Input getInput();

  /** Returns the Inspector command. */
  Inspector getInspector();

  /** Returns the LayerTree command. */
  LayerTree getLayerTree();

  /** Returns the Log command. */
  Log getLog();

  /** Returns the Memory command. */
  Memory getMemory();

  /** Returns the Network command. */
  Network getNetwork();

  /** Returns the Overlay command. */
  Overlay getOverlay();

  /** Returns the Page command. */
  Page getPage();

  /** Returns the Performance command. */
  Performance getPerformance();

  /** Returns the Security command. */
  Security getSecurity();

  /** Returns the ServiceWorker command. */
  ServiceWorker getServiceWorker();

  /** Returns the Storage command. */
  Storage getStorage();

  /** Returns the SystemInfo command. */
  SystemInfo getSystemInfo();

  /** Returns the Target command. */
  Target getTarget();

  /** Returns the Tethering command. */
  Tethering getTethering();

  /** Returns the Tracing command. */
  Tracing getTracing();

  /** Returns the Fetch command. */
  Fetch getFetch();

  /** Returns the WebAudio command. */
  WebAudio getWebAudio();

  /** Returns the WebAuthn command. */
  WebAuthn getWebAuthn();

  /** Returns the Media command. */
  Media getMedia();
}
