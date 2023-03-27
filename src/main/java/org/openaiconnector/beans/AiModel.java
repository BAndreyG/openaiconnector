package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

import java.util.List;

public class AiModel implements Bean {

    @Expose
    private String id;
    @Expose
    private String created;
    @Expose
    private String owned_by;
    @Expose
    private String object;
    @Expose
    private List<ModelPermission> permission;
    @Expose
    private String root;
    @Expose
    private String parent;


    public String getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public String getOwned_by() {
        return owned_by;
    }

    public String getObject() {
        return object;
    }

    public List<ModelPermission> getPermission() {
        return permission;
    }

    public String getRoot() {
        return root;
    }

    public String getParent() {
        return parent;
    }
}
