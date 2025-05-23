/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.arrow.flatbuf;

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressWarnings("unused")
public final class DictionaryEncoding extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_25_2_10(); }
  public static DictionaryEncoding getRootAsDictionaryEncoding(ByteBuffer _bb) { return getRootAsDictionaryEncoding(_bb, new DictionaryEncoding()); }
  public static DictionaryEncoding getRootAsDictionaryEncoding(ByteBuffer _bb, DictionaryEncoding obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DictionaryEncoding __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  /**
   * The known dictionary id in the application where this data is used. In
   * the file or streaming formats, the dictionary ids are found in the
   * DictionaryBatch messages
   */
  public long id() { int o = __offset(4); return o != 0 ? bb.getLong(o + bb_pos) : 0L; }
  /**
   * The dictionary indices are constrained to be non-negative integers. If
   * this field is null, the indices must be signed int32. To maximize
   * cross-language compatibility and performance, implementations are
   * recommended to prefer signed integer types over unsigned integer types
   * and to avoid uint64 indices unless they are required by an application.
   */
  public org.apache.arrow.flatbuf.Int indexType() { return indexType(new org.apache.arrow.flatbuf.Int()); }
  public org.apache.arrow.flatbuf.Int indexType(org.apache.arrow.flatbuf.Int obj) { int o = __offset(6); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }
  /**
   * By default, dictionaries are not ordered, or the order does not have
   * semantic meaning. In some statistical, applications, dictionary-encoding
   * is used to represent ordered categorical data, and we provide a way to
   * preserve that metadata here
   */
  public boolean isOrdered() { int o = __offset(8); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public short dictionaryKind() { int o = __offset(10); return o != 0 ? bb.getShort(o + bb_pos) : 0; }

  public static int createDictionaryEncoding(FlatBufferBuilder builder,
      long id,
      int indexTypeOffset,
      boolean isOrdered,
      short dictionaryKind) {
    builder.startTable(4);
    DictionaryEncoding.addId(builder, id);
    DictionaryEncoding.addIndexType(builder, indexTypeOffset);
    DictionaryEncoding.addDictionaryKind(builder, dictionaryKind);
    DictionaryEncoding.addIsOrdered(builder, isOrdered);
    return DictionaryEncoding.endDictionaryEncoding(builder);
  }

  public static void startDictionaryEncoding(FlatBufferBuilder builder) { builder.startTable(4); }
  public static void addId(FlatBufferBuilder builder, long id) { builder.addLong(0, id, 0L); }
  public static void addIndexType(FlatBufferBuilder builder, int indexTypeOffset) { builder.addOffset(1, indexTypeOffset, 0); }
  public static void addIsOrdered(FlatBufferBuilder builder, boolean isOrdered) { builder.addBoolean(2, isOrdered, false); }
  public static void addDictionaryKind(FlatBufferBuilder builder, short dictionaryKind) { builder.addShort(3, dictionaryKind, 0); }
  public static int endDictionaryEncoding(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DictionaryEncoding get(int j) { return get(new DictionaryEncoding(), j); }
    public DictionaryEncoding get(DictionaryEncoding obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
