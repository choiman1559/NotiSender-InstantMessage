package com.noti.plugin.message;

import androidx.room.TypeConverter;

public class MessageTypeConverter {
    @TypeConverter
    public static Message.Type toType(int type) {
        if (type == Message.Type.SENT.getCode()) {
            return Message.Type.SENT;
        }
        else if (type == Message.Type.RECEIVED.getCode()) {
            return Message.Type.RECEIVED;
        }
        else {
            throw new IllegalArgumentException("Could not recognize type");
        }
    }

    @TypeConverter
    public static int toInteger(Message.Type type) {
        return type.getCode();
    }
}
