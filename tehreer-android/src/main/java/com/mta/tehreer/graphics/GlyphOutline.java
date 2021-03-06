/*
 * Copyright (C) 2021 Muhammad Tayyab Akram
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

package com.mta.tehreer.graphics;

import com.mta.tehreer.internal.JniBridge;

final class GlyphOutline {
    static {
        JniBridge.loadLibrary();
    }

    long nativeOutline;

    public GlyphOutline(long nativeOutline) {
        this.nativeOutline = nativeOutline;
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            if (nativeOutline != 0) {
                nDispose(nativeOutline);
            }
        } finally {
            super.finalize();
        }
    }

    private static native void nDispose(long nativeOutline);
}
