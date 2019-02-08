/*
 * Copyright (C) 2019 Muhammad Tayyab Akram
 *
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
 */

package com.mta.tehreer.internal.sfnt.tables.fvar;

import androidx.annotation.NonNull;

import com.mta.tehreer.internal.sfnt.SfntTable;

public final class FontVariationsTable {
    private static final int MAJOR_VERSION = 0;
    private static final int MINOR_VERSION = 2;
    private static final int AXES_ARRAY_OFFSET = 4;
    private static final int AXIS_COUNT = 8;
    private static final int AXIS_SIZE = 10;
    private static final int INSTANCE_COUNT = 12;
    private static final int INSTANCE_SIZE = 14;

    private final @NonNull SfntTable data;

    public FontVariationsTable(@NonNull SfntTable data) {
        this.data = data;
    }

    public int majorVersion() {
        return data.readUInt16(MAJOR_VERSION);
    }

    public int minorVersion() {
        return data.readUInt16(MINOR_VERSION);
    }

    public int axesArrayOffset() {
        return data.readUInt16(AXES_ARRAY_OFFSET);
    }

    public int axisCount() {
        return data.readUInt16(AXIS_COUNT);
    }

    public int axisSize() {
        return data.readUInt16(AXIS_SIZE);
    }

    public int instanceCount() {
        return data.readUInt16(INSTANCE_COUNT);
    }

    public int instanceSize() {
        return data.readUInt16(INSTANCE_SIZE);
    }

    public @NonNull VariationAxisRecord[] axisRecords() {
        int axesArrayOffset = axesArrayOffset();
        int axisCount = axisCount();
        int axisSize = axisSize();
        VariationAxisRecord[] axisRecords = new VariationAxisRecord[axisCount];

        for (int i = 0; i < axisCount; i++) {
            axisRecords[i] = new VariationAxisRecord(data.subTable(axesArrayOffset + (i * axisSize)));
        }

        return axisRecords;
    }

    public @NonNull InstanceRecord[] instanceRecords() {
        int axesArrayOffset = axesArrayOffset();
        int axisCount = axisCount();
        int axisSize = axisSize();
        int axesEndOffset = axesArrayOffset + (axisCount * axisSize);
        int instanceCount = instanceCount();
        int instanceSize = instanceSize();
        InstanceRecord[] instanceRecords = new InstanceRecord[instanceCount];

        for (int i = 0; i < instanceCount; i++) {
            instanceRecords[i] = new InstanceRecord(data.subTable(axesEndOffset + (i * instanceSize)), axisCount, instanceSize);
        }

        return instanceRecords;
    }
}
