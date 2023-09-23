package com.ster.base;

import java.security.SecureRandom;
import java.util.UUID;

import org.apache.poi.util.SystemOutLogger;
import org.bson.codecs.UuidCodec;

import com.github.f4b6a3.uuid.codec.base.Base16Codec;

public class Test {
    public static void main(String[] args) {

        com.github.f4b6a3.uuid.codec.UuidCodec<String> codec = new Base16Codec();
        String string = codec.encode(UUID.randomUUID());


        // TODO Auto-generated method stub
    }

}
