package com.qeagle.devtools.protocol.commands;

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

import com.qeagle.devtools.protocol.events.security.CertificateError;
import com.qeagle.devtools.protocol.events.security.SecurityStateChanged;
import com.qeagle.devtools.protocol.support.annotations.EventName;
import com.qeagle.devtools.protocol.support.annotations.Experimental;
import com.qeagle.devtools.protocol.support.annotations.ParamName;
import com.qeagle.devtools.protocol.support.types.EventHandler;
import com.qeagle.devtools.protocol.support.types.EventListener;
import com.qeagle.devtools.protocol.types.security.CertificateErrorAction;

/** Security */
public interface Security {

  /** Disables tracking security state changes. */
  void disable();

  /** Enables tracking security state changes. */
  void enable();

  /**
   * Enable/disable whether all certificate errors should be ignored.
   *
   * @param ignore If true, all certificate errors will be ignored.
   */
  @Experimental
  void setIgnoreCertificateErrors(@ParamName("ignore") Boolean ignore);

  /**
   * Handles a certificate error that fired a certificateError event.
   *
   * @param eventId The ID of the event.
   * @param action The action to take on the certificate error.
   */
  @Deprecated
  void handleCertificateError(
      @ParamName("eventId") Integer eventId, @ParamName("action") CertificateErrorAction action);

  /**
   * Enable/disable overriding certificate errors. If enabled, all certificate error events need to
   * be handled by the DevTools client and should be answered with `handleCertificateError`
   * commands.
   *
   * @param override If true, certificate errors will be overridden.
   */
  @Deprecated
  void setOverrideCertificateErrors(@ParamName("override") Boolean override);

  /**
   * There is a certificate error. If overriding certificate errors is enabled, then it should be
   * handled with the `handleCertificateError` command. Note: this event does not fire if the
   * certificate error has been allowed internally. Only one client per target should override
   * certificate errors at the same time.
   */
  @EventName("certificateError")
  @Deprecated
  EventListener onCertificateError(EventHandler<CertificateError> eventListener);

  /** The security state of the page changed. */
  @EventName("securityStateChanged")
  EventListener onSecurityStateChanged(EventHandler<SecurityStateChanged> eventListener);
}
