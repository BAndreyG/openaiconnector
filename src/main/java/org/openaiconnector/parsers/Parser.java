package org.openaiconnector.parsers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openaiconnector.beans.Bean;

public class Parser {
    public static Bean parsingFrom(String json, Bean typeBean, String typeReport) throws Exception {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();

//        PartDataDeserializer partDataDeserializer = new PartDataDeserializer();
//        partDataDeserializer.registerDataType(typeReport);
//
//        builder.registerTypeAdapter(PartBean.class, partDataDeserializer);

        Gson gson = builder.create();
        return gson.fromJson(json, typeBean.getClass());
    }

    public static String parsingTo(Bean bean) throws Exception {
        GsonBuilder builder = new GsonBuilder();

        Gson gson = builder.create();
        return gson.toJson(bean);
    }
}
