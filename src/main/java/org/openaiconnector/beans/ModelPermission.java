package org.openaiconnector.beans;

import com.google.gson.annotations.Expose;

public class ModelPermission implements Bean {
    @Expose
    private String id;
    @Expose
    private String object;
    @Expose
    private String created;
    @Expose
    private boolean allow_create_engine;
    @Expose
    private boolean allow_sampling;
    @Expose
    private boolean allow_logprobs;
    @Expose
    private boolean allow_search_indices;
    @Expose
    private boolean allow_view;
    @Expose
    private boolean allow_fine_tuning;
    @Expose
    private String organization;
    @Expose
    private String group;
    @Expose
    private boolean is_blocking;

    public String getId() {
        return id;
    }

    public String getObject() {
        return object;
    }

    public String getCreated() {
        return created;
    }

    public boolean isAllow_create_engine() {
        return allow_create_engine;
    }

    public boolean isAllow_sampling() {
        return allow_sampling;
    }

    public boolean isAllow_logprobs() {
        return allow_logprobs;
    }

    public boolean isAllow_search_indices() {
        return allow_search_indices;
    }

    public boolean isAllow_view() {
        return allow_view;
    }

    public boolean isAllow_fine_tuning() {
        return allow_fine_tuning;
    }

    public String getOrganization() {
        return organization;
    }

    public String getGroup() {
        return group;
    }

    public boolean isIs_blocking() {
        return is_blocking;
    }
}
