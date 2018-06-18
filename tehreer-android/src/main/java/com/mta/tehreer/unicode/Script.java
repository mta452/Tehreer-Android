/*
 * Copyright (C) 2018 Muhammad Tayyab Akram
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

package com.mta.tehreer.unicode;

import com.mta.tehreer.internal.JniBridge;

public enum Script {
    INHERITED,
    COMMON,
    UNKNOWN,
    ARABIC,
    ARMENIAN,
    BENGALI,
    BOPOMOFO,
    CYRILLIC,
    DEVANAGARI,
    GEORGIAN,
    GREEK,
    GUJARATI,
    GURMUKHI,
    HANGUL,
    HAN,
    HEBREW,
    HIRAGANA,
    KATAKANA,
    KANNADA,
    LAO,
    LATIN,
    MALAYALAM,
    ORIYA,
    TAMIL,
    TELUGU,
    THAI,
    TIBETAN,
    BRAILLE,
    CANADIAN_ABORIGINAL,
    CHEROKEE,
    ETHIOPIC,
    KHMER,
    MONGOLIAN,
    MYANMAR,
    OGHAM,
    RUNIC,
    SINHALA,
    SYRIAC,
    THAANA,
    YI,
    DESERET,
    GOTHIC,
    OLD_ITALIC,
    BUHID,
    HANUNOO,
    TAGBANWA,
    TAGALOG,
    CYPRIOT,
    LIMBU,
    LINEAR_B,
    OSMANYA,
    SHAVIAN,
    TAI_LE,
    UGARITIC,
    BUGINESE,
    COPTIC,
    GLAGOLITIC,
    KHAROSHTHI,
    SYLOTI_NAGRI,
    NEW_TAI_LUE,
    TIFINAGH,
    OLD_PERSIAN,
    BALINESE,
    NKO,
    PHAGS_PA,
    PHOENICIAN,
    CUNEIFORM,
    CARIAN,
    CHAM,
    KAYAH_LI,
    LEPCHA,
    LYCIAN,
    LYDIAN,
    OL_CHIKI,
    REJANG,
    SAURASHTRA,
    SUNDANESE,
    VAI,
    IMPERIAL_ARAMAIC,
    AVESTAN,
    BAMUM,
    EGYPTIAN_HIEROGLYPHS,
    JAVANESE,
    KAITHI,
    TAI_THAM,
    LISU,
    MEETEI_MAYEK,
    OLD_TURKIC,
    INSCRIPTIONAL_PAHLAVI,
    INSCRIPTIONAL_PARTHIAN,
    SAMARITAN,
    OLD_SOUTH_ARABIAN,
    TAI_VIET,
    BATAK,
    BRAHMI,
    MANDAIC,
    CHAKMA,
    MEROITIC_CURSIVE,
    MEROITIC_HIEROGLYPHS,
    MIAO,
    SHARADA,
    SORA_SOMPENG,
    TAKRI,
    CAUCASIAN_ALBANIAN,
    BASSA_VAH,
    DUPLOYAN,
    ELBASAN,
    GRANTHA,
    PAHAWH_HMONG,
    KHOJKI,
    LINEAR_A,
    MAHAJANI,
    MANICHAEAN,
    MENDE_KIKAKUI,
    MODI,
    MRO,
    OLD_NORTH_ARABIAN,
    NABATAEAN,
    PALMYRENE,
    PAU_CIN_HAU,
    OLD_PERMIC,
    PSALTER_PAHLAVI,
    SIDDHAM,
    KHUDAWADI,
    TIRHUTA,
    WARANG_CITI,
    AHOM,
    HATRAN,
    ANATOLIAN_HIEROGLYPHS,
    OLD_HUNGARIAN,
    MULTANI,
    SIGNWRITING,
    ADLAM,
    BHAIKSUKI,
    MARCHEN,
    NEWA,
    OSAGE,
    TANGUT,
    MASARAM_GONDI,
    NUSHU,
    SOYOMBO,
    ZANABAZAR_SQUARE;

    static {
        JniBridge.loadLibrary();
    }

    private static final Script[] all = Script.values();

    static Script valueOf(byte nValue) {
        int index = (nValue - 1) & 0xFF;
        if (index < all.length) {
            return all[index];
        }

        return null;
    }

    byte value() {
        return (byte) (ordinal() + 1);
    }

    public int openTypeTag() {
        return nGetOpenTypeTag(value());
    }

    private static native int nGetOpenTypeTag(byte nValue);
}
