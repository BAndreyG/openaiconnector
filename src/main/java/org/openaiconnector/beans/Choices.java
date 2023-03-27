package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class Choices implements Bean {
    @Expose
    private String finish_reason;
    @Expose
    private String index;
}
