package com.qeagle.devtools.protocol.definition.types.type.array;

/*-
 * #%L
 * cdt-java-protocol-builder
 * %%
 * Copyright (C) 2018 TL
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

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.qeagle.devtools.protocol.definition.deserializers.impl.types.TypeArrayItemSubTypeJsonDeserializer;
import com.qeagle.devtools.protocol.definition.types.type.array.items.IntegerArrayItem;
import com.qeagle.devtools.protocol.definition.types.type.array.items.NumberArrayItem;
import com.qeagle.devtools.protocol.definition.types.type.array.items.RefArrayItem;
import com.qeagle.devtools.protocol.definition.types.type.array.items.StringArrayItem;
import lombok.Getter;

/**
 * Array item type.
 *
 * @author Gopinath
 */
@Getter
@JsonSubTypes({
  @JsonSubTypes.Type(value = StringArrayItem.class, name = "string"),
  @JsonSubTypes.Type(value = IntegerArrayItem.class, name = "integer"),
  @JsonSubTypes.Type(value = NumberArrayItem.class, name = "number"),
  @JsonSubTypes.Type(value = RefArrayItem.class, name = "ref"),
})
@JsonDeserialize(using = TypeArrayItemSubTypeJsonDeserializer.class)
public abstract class ArrayItem {
  private String description;
}
