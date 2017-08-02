package com.carlos.cartracking.model;

// Validation Class to be used in views so users can be alerted
// of failed or successful operations, see index CarControllerV1 for examples.

public class Validation {
    public String success;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public String failed;
}
