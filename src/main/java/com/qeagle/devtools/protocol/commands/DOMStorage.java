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

import com.qeagle.devtools.protocol.events.domstorage.DomStorageItemAdded;
import com.qeagle.devtools.protocol.events.domstorage.DomStorageItemRemoved;
import com.qeagle.devtools.protocol.events.domstorage.DomStorageItemUpdated;
import com.qeagle.devtools.protocol.events.domstorage.DomStorageItemsCleared;
import com.qeagle.devtools.protocol.support.annotations.EventName;
import com.qeagle.devtools.protocol.support.annotations.Experimental;
import com.qeagle.devtools.protocol.support.annotations.ParamName;
import com.qeagle.devtools.protocol.support.annotations.ReturnTypeParameter;
import com.qeagle.devtools.protocol.support.annotations.Returns;
import com.qeagle.devtools.protocol.support.types.EventHandler;
import com.qeagle.devtools.protocol.support.types.EventListener;
import com.qeagle.devtools.protocol.types.domstorage.StorageId;
import java.util.List;

/** Query and modify DOM storage. */
@Experimental
public interface DOMStorage {

  /** @param storageId */
  void clear(@ParamName("storageId") StorageId storageId);

  /** Disables storage tracking, prevents storage events from being sent to the client. */
  void disable();

  /** Enables storage tracking, storage events will now be delivered to the client. */
  void enable();

  /** @param storageId */
  @Returns("entries")
  @ReturnTypeParameter({List.class, String.class})
  List<List<String>> getDOMStorageItems(@ParamName("storageId") StorageId storageId);

  /**
   * @param storageId
   * @param key
   */
  void removeDOMStorageItem(
      @ParamName("storageId") StorageId storageId, @ParamName("key") String key);

  /**
   * @param storageId
   * @param key
   * @param value
   */
  void setDOMStorageItem(
      @ParamName("storageId") StorageId storageId,
      @ParamName("key") String key,
      @ParamName("value") String value);

  @EventName("domStorageItemAdded")
  EventListener onDomStorageItemAdded(EventHandler<DomStorageItemAdded> eventListener);

  @EventName("domStorageItemRemoved")
  EventListener onDomStorageItemRemoved(EventHandler<DomStorageItemRemoved> eventListener);

  @EventName("domStorageItemUpdated")
  EventListener onDomStorageItemUpdated(EventHandler<DomStorageItemUpdated> eventListener);

  @EventName("domStorageItemsCleared")
  EventListener onDomStorageItemsCleared(EventHandler<DomStorageItemsCleared> eventListener);
}
