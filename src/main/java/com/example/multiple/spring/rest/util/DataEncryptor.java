package com.example.multiple.spring.rest.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ws.security.WSSecurityException;
import org.apache.ws.security.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mlahariya
 * @version 1.0, Dec 2016
 */

@Component
public class DataEncryptor {

    private static Log log = LogFactory.getLog(DataEncryptor.class);

    @Autowired
    private MultiHelper helper;

    public MultiHelper getHelper() {
        return helper;
    }

    public void setHelper(MultiHelper helper) {
        this.helper = helper;
    }

    public String encode(String data) {
        byte[] dataBytes = data.getBytes();
        String output = Base64.encode(dataBytes);
        log.debug("ENCODING: " + data + " > " + output);
        return output;
    }

    public String decode(String data) {
        byte[] dataBytes;
        String output = null;
        try {
            dataBytes = Base64.decode(data);
            output = new String(dataBytes);
        } catch (WSSecurityException e) {
            log.warn("Failed to decode string [" + data + "]", e);
        }
        log.debug("DECODING: " + data + " > " + output);
        return output;
    }

    /**
     * @param value
     *            The value to obfuscate
     * @param obfuscateFlag
     *            <code>true</code> will obfuscate, <code>false</code>
     *            unobfuscate.
     * @return
     */
    public String obfuscate(String value, boolean obfuscateFlag, boolean numeric) {
        String newId = null;
        if (value != null) {
            if (obfuscateFlag) {
                newId = encode(value);
            } else {
                if (numeric) {
                    if (!helper.isLong(value)) {
                        newId = decode(value);
                    }
                }
            }
        }
        return newId;
    }

}
