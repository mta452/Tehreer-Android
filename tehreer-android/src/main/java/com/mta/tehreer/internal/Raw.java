/*
 * Copyright (C) 2017 Muhammad Tayyab Akram
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

package com.mta.tehreer.internal;

public class Raw {

    public static final int BYTES_IN_SIZE_TYPE = bytesInSizeType();

    private static native int bytesInSizeType();

    public static native byte getInt8Value(long pointer, int index);
    public static native int getInt32Value(long pointer, int index);
    public static native int getUInt16Value(long pointer, int index);
    public static native int getSizeValue(long pointer, int index);

    public static native void copyInt8Values(long pointer, byte[] array, int start, int length);
    public static native void copyUInt16Values(long pointer, int[] array, int start, int length);
    public static native void copySizeValues(long pointer, int[] array, int start, int length);
    public static native void copyInt32Floats(long pointer, float[] array, int start, int length, float scale);

    private Raw() {
    }
}
