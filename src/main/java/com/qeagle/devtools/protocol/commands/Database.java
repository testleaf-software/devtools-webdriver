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

import com.qeagle.devtools.protocol.events.database.AddDatabase;
import com.qeagle.devtools.protocol.support.annotations.EventName;
import com.qeagle.devtools.protocol.support.annotations.Experimental;
import com.qeagle.devtools.protocol.support.annotations.ParamName;
import com.qeagle.devtools.protocol.support.annotations.ReturnTypeParameter;
import com.qeagle.devtools.protocol.support.annotations.Returns;
import com.qeagle.devtools.protocol.support.types.EventHandler;
import com.qeagle.devtools.protocol.support.types.EventListener;
import com.qeagle.devtools.protocol.types.database.ExecuteSQL;
import java.util.List;

@Experimental
public interface Database {

  /** Disables database tracking, prevents database events from being sent to the client. */
  void disable();

  /** Enables database tracking, database events will now be delivered to the client. */
  void enable();

  /**
   * @param databaseId
   * @param query
   */
  ExecuteSQL executeSQL(
      @ParamName("databaseId") String databaseId, @ParamName("query") String query);

  /** @param databaseId */
  @Returns("tableNames")
  @ReturnTypeParameter(String.class)
  List<String> getDatabaseTableNames(@ParamName("databaseId") String databaseId);

  @EventName("addDatabase")
  EventListener onAddDatabase(EventHandler<AddDatabase> eventListener);
}
